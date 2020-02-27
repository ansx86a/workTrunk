package commonTool;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CaffeineCacheTest {


    @Test
    public void 測試cache() {
        //使用guava的例子搬過來的，主要都差不多，幾乎可以直接用只要改一點點就好
        //我想主要是多了一堆async的功能吧

        LoadingCache<String, Object> cache = Caffeine.newBuilder()
                .initialCapacity(2)//初值大小，hashmap預設16
                .maximumSize(10)//最多幾筆
                //.maximumWeight(1024*1024*1024)//最大1M，和maximumSize不能蓈存
                .expireAfterAccess(10, TimeUnit.MINUTES)//多久過期
                .refreshAfterWrite(1, TimeUnit.MINUTES)//多久重譯，要實作load才有
                .recordStats()//記錄log
                //.weakValues()//隨時可能被回收
                .softValues()//記憶體不足時回收，減低memory leak的風險，除非cache很大，不然使用maximumSize或maximumWeight即可
                .removalListener((k, v, cause) -> System.out.println(String.format("key[%s] value[%s] - " + cause, k, v)))//移除時的動作
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return key + " -2";
                    }
                });

        //System.out.println(cache.size());//沒有size
        System.out.println(cache.get("123"));
        for (int i = 0; i < 200; i++) {
            cache.get("" + i);//使用loader
            cache.getIfPresent("" + i);//無則回傳null
            cache.get("" + i, key -> key + " - not found");//callable優先loader
        }
        //System.out.println(cache.size());//沒有size
        System.out.println(cache.asMap());//注意，更改asMap會直接影嚮cache
        cache.refresh("192");//有實作loader時可用這個更新，好像是先執行remove再add
        cache.invalidateAll(Arrays.asList("199", "197"));//多資回收
        System.out.println(cache.asMap());
        cache.invalidate("195");//單筆回收
        System.out.println(cache.asMap());
        System.out.println(cache.stats());

        //執行發現 remove觸發的lister是非同步的
    }
}
