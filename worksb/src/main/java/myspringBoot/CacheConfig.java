package myspringBoot;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.ehcache.Status;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * 如果都沒有設任何cacheManger，spring在俅沒設要用那個cache時，預設使用concurrentHashMap
     *
     * @return
     */

    @Bean
    public CacheManager caffineCacheManger() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS);
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

    /**
     * 自已加工的cache，可以讓Caffine的CacheManger有多個不同的設定，就連設定值放在name上面也行得通
     *
     * @return
     */
    @Bean
    public CacheManager caffineCacheManger2() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager2();
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS);
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

    /**
     * spring只支援ehcache2.x，xml的寫法不一樣
     * 如果要用spring boot 有支援ehcache3
     * spring.cache.jcache.provider=org.ehcache.jsr107.EhcacheCachingProvider (介面符合即可)
     * spring.cache.jcache.config=classpaath:myEhCache.xml
     * 以下就自已硬幹弄出來的，還是可以用jcache就用jcache會比較好一點吧？？？
     *
     * @return
     * @throws IOException
     */
    @Bean
    @Primary
    public CacheManager ehCacheManger() throws IOException {
        XmlConfiguration xmlConfig = new XmlConfiguration(new ClassPathResource("myEhCache.xml").getURL());
        org.ehcache.CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
        return new MyEhCacheMange(cacheManager, xmlConfig);
    }


    static class CaffeineCacheManager2 extends CaffeineCacheManager {
        @Override
        protected com.github.benmanes.caffeine.cache.Cache<Object, Object> createNativeCaffeineCache(String name) {
            if (name.endsWith("2")) {
                return Caffeine.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();
            }
            return super.createNativeCaffeineCache(name);
        }
    }

    static class MyEhCacheMange extends AbstractTransactionSupportingCacheManager {
        private org.ehcache.CacheManager cacheManager;
        private XmlConfiguration xmlConfiguration;

        public MyEhCacheMange(org.ehcache.CacheManager cacheManager, XmlConfiguration xmlConfiguration) {
            this.cacheManager = cacheManager;
            this.xmlConfiguration = xmlConfiguration;
        }

        @Override
        protected Collection<? extends Cache> loadCaches() {
            Status status = this.cacheManager.getStatus();
            if (Status.AVAILABLE != status) {
                throw new IllegalStateException("cache status還在" + status);
            }
            Collection<Cache> caches = new LinkedList<>();
            for (Map.Entry<String, CacheConfiguration<?, ?>> entry : xmlConfiguration.getCacheConfigurations().entrySet()) {
                org.ehcache.Cache cache = this.cacheManager.getCache(entry.getKey(), entry.getValue().getKeyType(), entry.getValue().getValueType());
                caches.add(new MyEhCacheCache(cache, entry.getKey()));
            }
            return caches;
        }
    }

    static class MyEhCacheCache implements Cache {
        org.ehcache.Cache cache;
        String name;

        public MyEhCacheCache(org.ehcache.Cache cache, String name) {
            this.cache = cache;
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Object getNativeCache() {
            return this.cache;
        }

        @Override
        public ValueWrapper get(Object key) {
            return this.cache.get(key) == null ? null : new SimpleValueWrapper(this.cache.get(key));
        }

        @Override
        public <T> T get(Object key, Class<T> type) {
            return (T) cache.get(key);
        }

        @Override
        public <T> T get(Object key, Callable<T> valueLoader) {
            T value = (T) cache.get(key);
            if (value == null) {
                try {
                    value = valueLoader.call();
                    cache.put(key, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return value;
        }

        @Override
        public void put(Object key, Object value) {
            cache.put(key, value);
        }

        @Override
        public void evict(Object key) {
            cache.remove(key);
        }

        @Override
        public void clear() {
            cache.clear();
        }
    }
}
