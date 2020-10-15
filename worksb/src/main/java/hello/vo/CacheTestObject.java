package hello.vo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheTestObject {

    private static int count = 0;

    public int getCount() {
        return count++;
    }

    //cache不存來就執行並下次直接用就不執行了
    @Cacheable("counter")
    public int doCachable() {
        System.out.println("doCachable");
        return count++;
    }

    //不管cache存不存來，就是執行並更新
    @CachePut("counter")
    public int doCachPut() {
        System.out.println("doCachPut");
        return count++;
    }

    //刪除cache
    @CacheEvict("counter")
    public int doCacheEvict() {
        System.out.println("doCacheEvict");
        return count++;
    }


}
