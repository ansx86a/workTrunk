package hello.rest;

import hello.vo.CacheTestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * pom檔記得加cache和app要標@EnableCaching
 */
@RestController
@RequestMapping("cache")
public class CacheTestController {

    @Autowired
    CacheTestObject cacheTestObject;
    @Autowired
    CacheManager cacheManager;

    /**
     * http://localhost:8080/cache/counter
     */
    @GetMapping("counter")
    public int counter() {
        return cacheTestObject.getCount();
    }

    /**
     * http://localhost:8080/cache/counter
     */
    @GetMapping("cacheable")
    public int cacheable() {
        return cacheTestObject.doCachable();
    }

    /**
     * http://localhost:8080/cache/cachPut
     */
    @GetMapping("cachPut")
    public int cachePut() {
        return cacheTestObject.doCachPut();
    }

    /**
     * http://localhost:8080/cache/cacheEvict
     */
    @GetMapping("cacheEvict")
    public int cacheEvict() {
        return cacheTestObject.doCacheEvict();
    }

    @GetMapping("cacheManger")
    public void cacheManger() {
        System.out.println(cacheManager.getCacheNames());
        Cache cache = cacheManager.getCache("counter");
        //空值直接ne建構子就可以了，多個key的話就要塞到建構子裡去
        SimpleKey simpleKey = new SimpleKey();
        System.out.println(cache.get(simpleKey));

    }

}
