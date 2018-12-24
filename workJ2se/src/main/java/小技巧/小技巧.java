package 小技巧;

import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;

public class 小技巧 {

	@Test
	public void 避免NULL的取值法() {

		HashMap<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		HashMap<String, String> nullMap = null;
		// 在都有值的情況下
		System.out.println(Optional.ofNullable(map).map(o -> o.get("key1")).map(String::toString).orElse("NULL值"));
		// 在value沒有值的情況下
		System.out.println(Optional.ofNullable(map).map(o -> o.get("沒有值的key")).map(String::toString).orElse("NULL值"));
		// 在map 沒有值的情況下
		System.out
				.println(Optional.ofNullable(nullMap).map(o -> o.get("沒有值的key")).map(String::toString).orElse("NULL值"));

		// 測試到那裡開始沒有值，可以發現會轉成Optional.empty所以不會有null的問題
		// 在stream也可以用fiflter來過濾isEmpty
		Optional<HashMap<String, String>> option = Optional.ofNullable(map);
		System.out.println(option.map(o -> o.get("key1")));
		System.out.println(option.map(o -> o.get("沒有值的key")));
		System.out.println(option.map(o -> o.get("沒有值的key")).map(String::toString));
		System.out.println(option.map(o -> o.get("沒有值的key")).map(String::toString).isEmpty());
	}

}
