package 字串處理;

import com.google.common.base.Joiner;
import com.google.common.primitives.Longs;
import joptsimple.internal.Strings;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class 結合 {
    @Test
    public void guavaJoiner處理_空白會在null可代替別的字() {
        List<String> list = Arrays.asList(null, "", "0", "1", null, "2", "", "3", "");
        System.out.println(Joiner.on("|").skipNulls().join(list));//沒skip null 會出ex
        System.out.println(Joiner.on("|").useForNull("null string").join(list));
    }

    @Test
    public void guavaXXXXjoin處理2_空白和null會在() {
        List<String> list = Arrays.asList(null, "", "0", "1", null, "2", "", "3", "");
        System.out.println(Strings.join(list, "|"));
        System.out.println(Longs.join(",", 1, 2, 3, 4, 5));
    }

    @Test
    public void 原生String處理_窒白和null都會存在() {
        List<String> list = Arrays.asList(null, "", "0", "1", null, "2", "", "3", "");
        System.out.println(String.join("|", list));
        System.out.println(String.join("|", "A", "B", "C", null));
    }

    @Test
    public void StringUtils的處理_null和空白會不見() {
        List<String> list = Arrays.asList(null, "", "0", "1", null, "2", "", "3", "");
        System.out.println(StringUtils.join(list, "|"));

    }

    @Test
    public void lambda的處理_窒白和null都會存在() {
        List<String> list = Arrays.asList(null, "", "0", "1", null, "2", "", "3", "");
        String result = list.stream().collect(Collectors.joining("|"));
        System.out.println(result);
    }

    @Test
    public void util_StringJoiner不好用要一個一個add_只是列上去參考一下而已_窒白和null都會存在() {
        List<String> list = Arrays.asList(null, "", "0", "1", null, "2", "", "3", "");
        StringJoiner sj = new StringJoiner("!", "頭", "尾");
        list.forEach(o -> sj.add(o));
        System.out.println(sj.toString());
    }

}
