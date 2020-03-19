package commonTool;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.TreeMultiset;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GuavaListAndMap {


    @Test
    public void $1List建立時給初值後再add就會出錯() {
        try {
            ImmutableList<String> list1 = ImmutableList.of("a", "b", "c", "d");
            System.out.println(list1);
            list1.add("111");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void $2Map_key重覆或事後給值會掛點() {
        try {
            ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
            System.out.println(map);
            map = ImmutableMap.of("key1", "value1", "key2", "value2", "key1", "value1", "key2", "value2");
            System.out.println(map);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
            System.out.println(map);
            map.put("key", "value");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void $3Set的交集聯集() {
        HashSet setA = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet setB = Sets.newHashSet(4, 5, 6, 7, 8);

        SetView union = Sets.union(setA, setB);
        System.out.println("union:聯集，結果重覆的只會出現一次，等於2個set放到一個set");
        union.forEach(o -> {
            System.out.println(o);
        });
        SetView difference = Sets.difference(setA, setB);
        System.out.println("difference:差集，等於left outer join吧(left - inner)");
        for (Object integer : difference.toArray()) {
            System.out.println(integer);
        }
        System.out.println("difference:交集，等於inner join");
        SetView intersection = Sets.intersection(setA, setB);
        System.out.println("intersection:");
        for (Object integer : intersection.toArray()) {
            System.out.println(integer);
        }
        System.out.println("symmetricDifference:outter join吧，等於union - inner");
        SetView symmetricDifference = Sets.symmetricDifference(setA, setB);
        for (Object integer : symmetricDifference.toArray()) {
            System.out.println(integer);
        }
    }

    @Test
    public void $找出Map的差集() {
        ImmutableMap<String, Integer> mapA = ImmutableMap.of("key1", 1, "key2", 2, "key3", 3, "key4", 3);
        ImmutableMap<String, Integer> mapB = ImmutableMap.of("key3", 3, "key4", 4, "key5", 5, "key6", 6);

        MapDifference differenceMap = Maps.difference(mapA, mapB);
        differenceMap.areEqual();

        System.out.println("沒有仔細研究，但是大概上猜了一下");
        System.out.println("entriesDiffering:找出key相同，值不同的東西來，用一個物件包左值和右值");
        Map entriesDiffering = differenceMap.entriesDiffering();
        System.out.println(entriesDiffering);
        System.out.println(entriesDiffering.get("key4").getClass());
        System.out.println(entriesDiffering);

        System.out.println("entriesOnlyOnLeft:找出key只在左邊出現的");
        Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();
        System.out.println(entriesOnlyOnLeft);
        System.out.println("entriesOnlyOnRight:找出key只在右邊出現的");
        Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();
        System.out.println(entriesOnlyOnRight);
        System.out.println("entriesInCommon:找出key只在2邊都出現的");
        Map entriesInCommon = differenceMap.entriesInCommon();
        System.out.println(entriesInCommon);
    }

    @Test
    public void 可以重覆key值的map並自動把value用list存() {
        MultimapBuilder.treeKeys().hashSetValues().build();// 可以有幾種選擇，很屌
        ListMultimap<String, String> map = MultimapBuilder.hashKeys().arrayListValues().build();
        map.put("1", "a");
        map.put("1", "bb");
        map.put("2", "cc");
        System.out.println(map);
        System.out.println(map.get("1").getClass());
        System.out.println(map.get("1") instanceof List);// true

    }

    @Test
    public void 反轉Map使用ListMultiMap() {
        //正常來說，key是唯一，value不是唯一的情況
        Map<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v1", "k3", "v3");
        //中介層為SET
        SetMultimap<String, String> setMultimap = Multimaps.forMap(map);
        //然後就可以key value轉換了，比BIMap好用吧，但應該比較浪費資源
        Multimap<String, String> result = Multimaps.invertFrom(setMultimap, MultimapBuilder.hashKeys().arrayListValues().build());
        System.out.println(result.get("v1"));
        result.put("v1", "new k1");
        result.put("new v2", "new k2");
        result.put("new v2", "k2");
        //注意，之後轉回map因為的value會變成List
        Map<String, Collection<String>> resultMap = Multimaps.invertFrom(result, MultimapBuilder.hashKeys().arrayListValues().build()).asMap();
        for (Map.Entry<String, Collection<String>> o : resultMap.entrySet()) {
            System.out.println(o);
        }
    }

    @Test
    public void 使用Set來計數() {
        TreeMultiset.create();
        //Multiset<String> set = HashMultiset.create();
        HashMultiset<String> set = HashMultiset.create();

        set.add("1");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("2");
        System.out.println(set.count("1"));
        System.out.println(set.count("2"));
        System.out.println(set.count("3"));
        System.out.println(set);
        System.out.println(set.elementSet());
        set.stream().forEach(o -> System.out.println(o));
    }
}
