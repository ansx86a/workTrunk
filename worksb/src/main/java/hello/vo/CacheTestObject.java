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


    // value和cacheNames都相同，是用來指字快取的名字
    // key要用spel，#argName，或是root(可省略)，ex： methodName,method.name,target,targetClass,args[0],caches[0].name
    // 補充key，可用#p0斂表參數一，省略key時就是spring用全部的argument去組key出來
    // keyGenerator和key只能選用其一
    // cacheManager，當有多個cacheManger時可指定用那一個
    // cacheResolver 和 cacheManager只能選其一，用來分析要用那一個cache，要自已寫規則
    // condition 符合spel的才加入cache
    // unless 符合spel的不加入cache
    // Cacheable在執行method就會先去cache取，取不到再執行程式
    //cache不存來就執行並下次直接用就不執行了
    @Cacheable(value = "counter", key = "''")//只有ehcache要加上key，其它的用spring預設的simpleKey即可
    public int doCachable() {
        System.out.println("doCachable");
        return count++;
    }

    //測議是否同時共用2個cache，所以加一個來辦別
    @Cacheable(value = "counter2", key = "''")
    public int doCachable2() {
        System.out.println("doCachable2");
        return count++;
    }


    //CachePut是在method執行完成後，去覆蓋cache
    //不管cache存不存來，就是執行並更新
    @CachePut(value ="counter", key = "''")
    public int doCachPut() {
        System.out.println("doCachPut");
        return count++;
    }

    //刪除cache
    //allEntries=true時，會清空cache
    //beforeInvocation，改成在執行前就執行清cache的動作，可避免清除動作被程式throw ex影嚮
    @CacheEvict(value ="counter", key = "''")
    public int doCacheEvict() {
        System.out.println("doCacheEvict");
        return count++;
    }
    //@CacheConfig，可在class宣告，然後method都有預設值

//注意，Cacheable，CachePut，CacheEvict只能單獨使用不能有複合和重覆的存在，如有要混合使用，要用@Chaching


}
