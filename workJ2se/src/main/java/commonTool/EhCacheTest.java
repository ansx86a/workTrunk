package commonTool;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.impl.config.store.disk.OffHeapDiskStoreConfiguration;
import org.ehcache.xml.XmlConfiguration;
import org.junit.Test;
import tool.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class EhCacheTest {


    @Test
    public void 初始化cache() {
        //初始化manager時，就設好有什麼cache，另外cacheManager是closeable可以放到try cache中的resource
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();//build傳true就可以隊用下一行的init了
        cacheManager.init();
        //拿到cache
        Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);
        //新建cache，注意不能同名字的建2次
        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));

        myCache.put(1L, "da one!");//放到cache
        String value = myCache.get(1L);

        cacheManager.removeCache("preConfigured");//移除cache，就可以重新new了
        cacheManager.close();
        //關掉後，cache就全部不能用了
    }

    @Test
    public void testXml() throws MalformedURLException {
        File file = new File("C:\\allenWrok\\git\\workTrunk\\workJ2se\\src\\main\\java\\commonTool\\myEhCache.xml");

        Configuration xmlConfig = new XmlConfiguration(file.toURL());
        try (CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig)) {

            myCacheManager.init();
            Cache<String, String> foo = myCacheManager.getCache("foo", String.class, String.class);
            for (int i = 0; i < 10000; i++) {
                foo.put("" + i, "" + i);
            }
            for (int i = 0; i < 10000; i++) {
                if (foo.containsKey("" + i)) System.out.println(foo.get("" + i));
            }
        }
    }

    public void testCluster() {
        //可能要使用 terracotta server，先跳過

//        CacheManagerBuilder<PersistentCacheManager> clusteredCacheManagerBuilder =
//                CacheManagerBuilder.newCacheManagerBuilder()
//                        .with(ClusteringServiceConfigurationBuilder.cluster(URI.create("terracotta://localhost/my-application"))
//                                .autoCreate(c -> c));
//        PersistentCacheManager cacheManager = clusteredCacheManagerBuilder.build(true);
//        cacheManager.close();
    }

    @Test
    public void 可儲存在三種介質() {
        PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(new File("z:/ehcache/cacheDataInDisk")))//宣告儲存的位置
                .withCache("threeTieredCache",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder()
                                        .heap(10, EntryUnit.ENTRIES)
                                        .offheap(1, MemoryUnit.MB)//最小要1MB不然會出錯
                                        .disk(20, MemoryUnit.MB, true)
                        )
                                .withService(new OffHeapDiskStoreConfiguration(2))//預設好像是分割16個區段來讀寫，可設定這個值減少(有必要再設，不然這段只是記錄)
                ).build(true);

        Cache<Long, String> threeTieredCache = persistentCacheManager.getCache("threeTieredCache", Long.class, String.class);
        int count = 0;
        for (long i = 0; i < 10000; i++) {
            //第一次 threeTieredCache.put(i,"xxxxxx" +i);
            //第二次 驗存在硬碟的還在不在
            if (threeTieredCache.get(i) != null) {
                ++count;
            }
        }
        System.out.println("共有幾筆=" + count);//結果1W筆都在
//        persistentCacheManager.destroy();//從硬碟刪除
//        persistentCacheManager.destroyCache("xxxCache");//從硬碟刪除

        persistentCacheManager.close();

    }

    public void 其它設定() {
        CacheConfiguration<Long, String> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                ResourcePoolsBuilder.heap(100))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(20)))//設定20秒後逾時
                .withSizeOfMaxObjectGraph(1000)//假如該物件內容有超過設定的物件數，就不存到cache，預設1000
                .withSizeOfMaxObjectSize(100, MemoryUnit.B)//假如該物件超過設定的大小，不存到cache，預設Long的max
                .build();


        CacheManagerBuilder.newCacheManagerBuilder()
                .withDefaultSizeOfMaxObjectGraph(2000)//沒有設定多久過期時，就保留這個設定值的數量
                .withDefaultSizeOfMaxObjectSize(10, MemoryUnit.B)//沒有設定多久過期時，就保留這個設定值的大小
                .withCache("cache001", cacheConfiguration)//使用上面的cache config

                .build(true);


        //cluster可以設定timeout

    }


}
