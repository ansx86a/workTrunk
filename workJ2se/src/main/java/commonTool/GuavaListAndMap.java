package commonTool;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class GuavaListAndMap {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GuavaListAndMap g = new GuavaListAndMap();

        // System.out.println("List特點是資料給完初值就不會變了");
        // g.$1List建立時給初值後再add就會出錯();
        // System.out.println("Map特點同上，另外key重覆或事後給值會掛點");
        // g.$2Map_key重覆或事後給值會掛點();
        // System.out.println("Set的交集和聯集");
        // g.$3Set的交集聯集();

        g.$4();
    }

    public void $1List建立時給初值後再add就會出錯() {
        try {
            ImmutableList<String> list1 = ImmutableList.of("a", "b", "c", "d");
            System.out.println(list1);
            list1.add("111");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

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

    public void $4() {
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

}
