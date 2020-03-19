package commonTool;


import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Table;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Guava的功能 {

    public static void main(String a[]) {
        // http://ifeve.com/google-guava/
        // http://www.codedata.com.tw/java/guava-tutorial-1-getting-started
        // http://ifeve.com/google-guava-collectionutilities/

        // 建議看一下Guava，好像有蠻多簡單的寫法
    }

    @Test
    public void $使用table可支援2key_1value() {
        //立用pair的特性，也可是等於使用table，或是拓展table到6個key？
        Pair p = Pair.of("A", "B");
        System.out.println(p.hashCode());


        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        int seatCount
                = universityCourseSeatTable.get("Mumbai", "IT");
        System.out.println(seatCount);
        Integer seatCountForNoEntry
                = universityCourseSeatTable.get("Oxford", "IT");
        System.out.println(seatCountForNoEntry);


    }

    @Test
    public void givenTable_whenContains_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        boolean entryIsPresent
                = universityCourseSeatTable.contains("Mumbai", "IT");
        boolean courseIsPresent
                = universityCourseSeatTable.containsColumn("IT");
        boolean universityIsPresent
                = universityCourseSeatTable.containsRow("Mumbai");
        boolean seatCountIsPresent
                = universityCourseSeatTable.containsValue(60);

    }

    @Test
    public void givenTable_whenRemove_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);

        int seatCount
                = universityCourseSeatTable.remove("Mumbai", "IT");
        //remove回傳value，沒remove到回傳null

    }

    @Test
    public void givenTable_whenColumn_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Map<String, Integer> universitySeatMap
                = universityCourseSeatTable.column("IT");

        //assertThat(universitySeatMap).hasSize(2);
        //assertThat(universitySeatMap.get("Mumbai")).isEqualTo(60);
        //assertThat(universitySeatMap.get("Harvard")).isEqualTo(120);
    }

    @Test
    public void givenTable_whenColumnMap_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Map<String, Map<String, Integer>> courseKeyUniversitySeatMap
                = universityCourseSeatTable.columnMap();

        //assertThat(courseKeyUniversitySeatMap).hasSize(3);
        //assertThat(courseKeyUniversitySeatMap.get("IT")).hasSize(2);
        //assertThat(courseKeyUniversitySeatMap.get("Electrical")).hasSize(1);
        //assertThat(courseKeyUniversitySeatMap.get("Chemical")).hasSize(1);
    }

    @Test
    public void givenTable_whenRow_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Map<String, Integer> courseSeatMap
                = universityCourseSeatTable.row("Mumbai");

        //assertThat(courseSeatMap).hasSize(2);
        //assertThat(courseSeatMap.get("IT")).isEqualTo(60);
        //assertThat(courseSeatMap.get("Chemical")).isEqualTo(120);
    }

    @Test
    public void givenTable_whenRowKeySet_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Set<String> universitySet = universityCourseSeatTable.rowKeySet();

        //assertThat(universitySet).hasSize(2);
    }

    @Test
    public void givenTable_whenColKeySet_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Set<String> courseSet = universityCourseSeatTable.columnKeySet();

        //assertThat(courseSet).hasSize(3);
    }
//=====上面都是table，都是用抄的沒仔細看過====================================================================================================================


    @Test
    public void 驗証() {
        //和apache的validate差不多，想用那個就用那個吧
        //java7 有Objects.requireNonNull有87像
        Preconditions.checkArgument(true, "錯誤訊息");
        Preconditions.checkNotNull(new Object(), "錯誤訊息，可用預存字:%s", "error info");

    }

    @Test
    public void Iterables() {
        //計算資料和取得第一或最後一個
        List<String> list = ImmutableList.of("0", "1", "1", "1", "1", "1", "1", "1", "9");
        System.out.println(Iterables.getFirst(list, null));
        System.out.println(Iterables.getLast(list, null));
        System.out.println(Iterables.frequency(list, "1"));

        //記錄一下，Iterables.toArray() 可以直接傳class為型別不用再傳什麼array
    }



    @Test
    public void testEventBus() {
        //這是event driven？
        //這是訂閱，適合用來寫和訂閱相關的東西
        EventBus bus = new EventBus();//AsyncEventBus也可以用
        bus.register(this);//可註聞多個物件
        bus.post("這是event");//如有同樣type的subscribe的method，會都被觸發
        bus.post(123);//沒有對應的method，就不會被執行,會變deadEvent
        bus.unregister(this);
        bus.post("這是event");
        System.out.println("end");
    }

    @Subscribe
    public void event1(String event) {
        System.out.println("event->" + event);
    }

    @Subscribe
    public void event(DeadEvent deadEvent) {
        System.out.println("this is deadEvent ->" + deadEvent);
    }

    @Test
    public void 測試cache() throws ExecutionException {

        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                .initialCapacity(2)//初值大小，hashmap預設16
                .maximumSize(10)//最多幾筆
                //.maximumWeight(1024*1024*1024)//最大1M，和maximumSize不能蓈存
                .expireAfterAccess(10, TimeUnit.MINUTES)//多久過期
                .refreshAfterWrite(1, TimeUnit.MINUTES)//多久重譯，要實作load才有
                .recordStats()//記錄log
                //.weakValues()//隨時可能被回收
                .softValues()//記憶體不足時回收，減低memory leak的風險，除非cache很大，不然使用maximumSize或maximumWeight即可
                .removalListener(o -> System.out.println(String.format("key[%s] value[%s]", o.getKey(), o.getValue())))//移除時的動作
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return key + " -2";
                    }
                });

        System.out.println(cache.size());
        System.out.println(cache.get("123"));
        for (int i = 0; i < 200; i++) {
            cache.get("" + i);//使用loader
            cache.getIfPresent("" + i);//無則回傳null
            cache.get("" + i, () -> "not found");//callable優先loader
        }
        System.out.println(cache.size());
        System.out.println(cache.asMap());//注意，更改asMap會直接影嚮cache
        cache.refresh("192");//有實作loader時可用這個更新，好像是先執行remove再add
        cache.invalidateAll(Arrays.asList("199", "197"));//多資回收
        System.out.println(cache.asMap());
        cache.invalidate("195");//單筆回收
        System.out.println(cache.asMap());
        System.out.println(cache.stats());

    }


}
