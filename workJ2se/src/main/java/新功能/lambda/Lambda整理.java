package 新功能.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda整理 {

	// good:http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
	// https://www.oreilly.com/learning/java-8-functional-interfaces
	public static void main(String[] args) {
		Lambda整理 l = new Lambda整理();
		l.$8轉成map或list();
		
		//要管線作業不可缺的東西
		//IntStream.range(1, 4)
		
	}

	public void $1無參數寫法() {
		// 單行不回傳
		Runnable runnbale = () -> System.out.println("run me!");
		// 多行，可回傳
		Runnable runnbale2 = () -> {
			System.out.println("run me!");
		};
	}

	public void $2有參數寫法() {
		// 省略()和型別和{}
		Comparable<Integer> c0 = i -> 0;
		// 省略()和型別
		Comparable<Integer> c = i -> {
			return 0;
		};
		// 省略型別
		Comparable<Integer> c2 = (i) -> {
			return 0;
		};
		// 什麼都沒省
		Comparable<Integer> c3 = (Integer i) -> {
			return 0;
		};
	}

	public void $3_2() {
		System.out.println("yyyy" + this.getClass());
	}

	public void $3應用在thread上() {
		Thread t1 = new Thread(() -> System.out.println("xxxx"));
		Thread t2 = new Thread(this::$3_2);
		t1.start();
		t2.start();
		// 這裡不用sleep是因為要寫try catch很麻煩
		t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++)
				System.out.println("t1t1" + this.getClass());
		});
		t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++)
				System.out.println("t2t2" + this.getClass());
		});
		// 這裡有交錯就可以了
		t1.start();
		t2.start();

	}

	public void $4模仿delgate委派() {
		// 前面是input，後面是return;
		Function<String, Integer> f = x -> Integer.valueOf(x + x);
		System.out.println(f.apply("23"));

		Function<Integer, Double> f2 = x -> x / 3.0;
		System.out.println(f2.apply(23));

		// 完整的寫法
		Function<String, Integer> f3 = (String x) -> {
			System.out.println("這裡是委派的內部");
			return Integer.valueOf(x + x);
		};
		System.out.println(f3.apply("34"));

		// 這也是應用在委派，只是沒有回傳值，所以和Function差不多
		Consumer<String> f4 = x -> System.out.println(x + "什麼鬼啊");
		f4.accept("78");

	}

	public void $5map和list的foreach() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "key0");
		map.put(33, "key1");
		map.put(567, "key2");
		map.forEach((k, v) -> {
			System.out.println("key=" + k.getClass() + "," + k + "," + v);
		});
		// 等同下行
		// map.forEach((k, v) -> System.out.println("key=" + k.getClass() + "," + k + "," + v));
		map.keySet().forEach(s -> System.out.println("set->" + s));
		Arrays.asList(map.keySet().toArray()).forEach(s -> System.out.println("list->" + s));

	}

	public void $6集合的stream同法() {
		List<String> list = Arrays.asList("list1", "aadddd", "vvvxxx", "zzzssss");
		// 過濾
		list.stream().filter(o -> "vvv".compareTo(o) > 0).forEach(s -> System.out.println(s));
		System.out.println("=========");
		// 有身體的寫法
		list.stream().filter(o -> {
			return "vvv".compareTo(o) > 0;
		}).forEach(s -> System.out.println(s));
		System.out.println("=========");
		// 包成集合
		List list2 = list.stream().filter(o -> "vvv".compareTo(o) > 0).collect(Collectors.toList());
		System.out.println(list2);
		Optional<String> option = list.stream().filter(o -> "vvv".compareTo(o) > 0).findFirst();
		if (option.isPresent()) {
			System.out.println("result = " + option.get());
		} else {
			System.out.println("" + null);
		}
		option.ifPresent(o -> System.out.println(o));

	}

	public void $7管線stream用法() {
		// 平行運作，以下程式要證明是平行運作，如果是4核就看得出來是一次處理4行程式
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			list.add(i);
		}
		list.parallelStream().forEach(o -> {
			System.out.println(o);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void $8轉成map或list() {
		List<Person> list = Person.createRoster();

		System.out.println(list.toString().replaceAll("Person ", "\r\n"));
		List list2 = list.stream().filter(o -> o.getAge() > 15).collect(Collectors.toList());
		System.out.println("==================");
		System.out.println(list2.toString().replaceAll("Person ", "\r\n"));
		System.out.println("map例子2");
		list2 = list.stream().filter(o -> o.getAge() > 15).map(Person::getAge).collect(Collectors.toList());
		System.out.println(list2);
		System.out.println("map例子2");
		list2 = list.stream().filter(o -> o.getAge() > 15).map(o -> o.getAge() * 10).collect(Collectors.toList());
		System.out.println(list2);
		Function<Person, Map> f = o -> {
			HashMap map = new HashMap();
			map.put("key", o.getBirthday());
			return map;
		};
		System.out.println("map例子3加轉list");
		list2 = list.stream().filter(o -> o.getAge() > 15).map(f).collect(Collectors.toList());
		System.out.println(list2);
		System.out.println("轉set");
		Set set = list.stream().map(o -> o.getGender()).collect(Collectors.toSet());
		System.out.println(set);
		set = list.stream().map(o -> o.getGender()).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);
		// 一般轉map
		System.out.println("轉map");
		Map map = list.stream().collect(Collectors.toMap(Person::getName, Person::getEmailAddress));
		System.out.println(map);
		map = list.stream().collect(Collectors.toMap(Person::getName, o -> o.getEmailAddress()));
		System.out.println(map);
		map = list.stream().collect(Collectors.toMap(x -> x.getName() + "xxx", o -> o.getEmailAddress()));
		System.out.println(map);
		list.add(list.get(0));// 加一筆一樣
		map = list.stream().collect(Collectors.toMap(Person::getName, Person::getEmailAddress, (x, y) -> x + "分開" + y));
		System.out.println(map.toString().replaceAll("@", "\r\n"));

		// 分組成key,list<Person>
		map = list.stream().collect(Collectors.groupingBy(o -> o.getName() + "xxx"));
		System.out.println(map);
		System.out.println("轉間隔符號");
		String result = list.stream().map(o -> o.getName()).collect(Collectors.joining(", ", "開頭", "結尾"));
		System.out.println(result);

	}

	public void $9轉成數字的應用() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		// 算總和
		System.out.println(list.parallelStream().mapToInt(o -> o).sum());
		// 取最大，最小，平均
		System.out.println(list.stream().mapToInt(o -> o).max().getAsInt());
		System.out.println(list.stream().mapToInt(o -> o).min().getAsInt());
		System.out.println(list.stream().mapToInt(o -> o).average().getAsDouble());
		System.out.println(list.stream().distinct().mapToInt(o -> o).average().getAsDouble());
		System.out.println(Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6 }).asLongStream().sum());
		System.out.println(Stream.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 10).mapToInt(o -> o).sum());

	}

	public void $10判斷式導出的應用() {
		// 等同是把filter的判斷抽出來，由主method或controler傳入
		List list = eval(in -> in % 2 > 0);
		System.out.println(list);
	}

	public List<Object> eval(Predicate<Integer> p) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		for (Integer n : list) {
			if (p.test(n)) {
				System.out.println(n + " ");
			}
		}
		return list.stream().filter(p).collect(Collectors.toList());
	}

	public void $11排序() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		list.sort(Integer::compare);// 這裡的應用等同下行，注意的是介面裡面有內容實作，怪怪的
		// list.sort(new Comparator() {
		// @Override
		// public int compare(Object o1, Object o2) {
		// return 0;
		// }
		// });

		System.out.println(list);
		Comparator<Integer> c = (x, y) -> {
			return y - x;
		};
		List list2 = list.stream().sorted(c).collect(Collectors.toList());
		// 這裡可以知道stream不會去改本來的值
		System.out.println(list);
		System.out.println(list2);
	}

	public void $12Match() {
		// 以下就等於跑forEach後，有match後就return
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("B");
		});
		// 和上面相反，就是跑forEach，有不match的就return
		Stream.of("a2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).allMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});
	}

}
