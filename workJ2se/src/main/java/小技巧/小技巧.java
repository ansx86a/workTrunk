package 小技巧;

import java.util.HashMap;
import java.util.Optional;

public class 小技巧 {

	public static void main(String[] args) {

		$1避免用等於null做巢狀判斷();

	}

	public static void $1避免用等於null做巢狀判斷() {

		HashMap<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		String s = "value1";
		boolean b = s.equals(Optional.ofNullable(map).map(o -> o.get("key1")).map(String::toString).orElse(null));
		System.out.println(b);
		b = s.equals(Optional.ofNullable(map).map(o -> o.get("keyxxx")).map(String::toString).orElse(null));
		System.out.println(b);

		// 上面仍然太長
		Optional<HashMap<String, String>> option = Optional.ofNullable(map);
		String sss = option.map(o -> o.get("keyxxx")).map(String::toString).orElse(null);
		System.out.println(sss);
		sss = option.map(o -> o.get("key1")).map(String::toString).orElse(null);
		System.out.println(sss);
	}

}
