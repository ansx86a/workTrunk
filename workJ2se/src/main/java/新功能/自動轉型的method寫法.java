package 新功能;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 老實說這是一個廢程式，不過倒是有一些好玩的語言待整理
 * @author ai
 *
 */
public class 自動轉型的method寫法 {

	private Map<String, Object> attrs_ = new HashMap<>();

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// 新增例子，可以處理
		List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		listInt = listFilter(listInt, o -> o > 4, o -> o < 7);
		System.out.println(listInt);

		// 注意，本程式最後無法正常執行，主要是要看java語法
		自動轉型的method寫法 t = new 自動轉型的method寫法();
		t.addKey(ArrayList.class, "list");
		t.addKey(HashMap.class, "map");
		ArrayList list = t.get("list");
		HashMap map = t.get("map");
		System.out.println(list.getClass());
		System.out.println(map.getClass());
		ArrayList errorType = t.get("map");// 轉型失敗的exception
		System.out.println(errorType.getClass());

	}

	// 這裡的<T>是吃Class<T> type，重點就擺在傳進來的type參數
	public <T> void addKey(Class<T> type, String key) throws InstantiationException, IllegalAccessException {
		attrs_.put(key, type.newInstance());
	}

	// 這邊要注意的是(T) attrs_.get(dest)是轉型
	// ArrayList list = t.get("list");，public<T>的<T>是吃ArrayList list
	// 的list，幫你轉型，有點不安全的語法
	public <T> T get(String dest) {
		return (T) attrs_.get(dest);
	}

	// 如果寫一個可以處理lambda的東西，可以回傳List<T>
	public static <T> List<T> listFilter(List<T> list, Predicate<T>... p) {
		Stream<T> s = list.stream();
		for (Predicate<T> subP : p) {
			s = s.filter(subP);
		}
		List<T> newList = s.collect(Collectors.toList());
		return newList;
	}

}
