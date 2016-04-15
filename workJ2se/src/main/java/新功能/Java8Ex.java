package 新功能;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
//方法引用	  等价的lambda表达式	
//String::valueOf		x -> String.valueOf(x)
//Object::toString		x -> x.toString()
//x::toString			() -> x.toString()
//ArrayList::new		() -> new ArrayList<>()

//filter 1 - 排除所有与断言不匹配的元素。
//map 1 2 3 4 - 通过Function对元素执行一对一的转换。
//flatMap 1 2 3 4 5 - 通过FlatMapper将每个元素转变为无或更多的元素。
//peek 1 - 对每个遇到的元素执行一些操作。主要对调试很有用。
//distinct 1 - 根据.equals行为排除所有重复的元素。这是一个有状态的操作。
//sorted 1 2 - 确保流中的元素在后续的操作中，按照比较器（Comparator）决定的顺序访问。这是一个有状态的操作。
//limit 1 - 保证后续的操作所能看到的最大数量的元素。这是一个有状态的短路的操作。
//substream 1 2 - 确保后续的操作只能看到一个范围的（根据index）元素。像不能用于流的String.substring一样。也有两种形式，一种有一个开始索引，一种有一个结束索引。二者都是有状态的操作，有一个结束索引的形式也是一个短路的操作。
//末端的操作：
//forEach 1 - 对流中的每个元素执行一些操作。
//toArray 1 2 - 将流中的元素倾倒入一个数组。
//reduce 1 2 3 - 通过一个二进制操作将流中的元素合并到一起。
//collect 1 2 - 将流中的元素倾倒入某些容器，例如一个Collection或Map.
//min 1 - 根据一个比较器找到流中元素的最小值。
//max 1 -根据一个比较器找到流中元素的最大值。
//count 1 - 计算流中元素的数量。
//anyMatch 1 - 判断流中是否至少有一个元素匹配断言。这是一个短路的操作。
//allMatch 1 - 判断流中是否每一个元素都匹配断言。这是一个短路的操作。
//noneMatch 1 - 判断流中是否没有一个元素匹配断言。这是一个短路的操作。
//findFirst 1 - 查找流中的第一个元素。这是一个短路的操作。
//findAny 1 - 查找流中的任意元素，可能对某些流要比findFirst代价低。这是一个短路的操作。

public class Java8Ex {

	public static void main(String... arg) {
		// ex1
		FunctionExTest();
		// ex2
		// StreamExTest();
	}

	public static void StreamExTest() {
		new StreamEx().run();
	}

	static class StreamEx {
		public StreamEx() {

		}

		public void run() {
			ArrayList<String> list = new ArrayList<>();
			list.add("11");
			list.add("22");
			list.add("33");
			list.add("33");
			list.add("44");
			// distinct重點是hashcode 和 equals 都要override才有用
			list.stream().distinct().forEach(o -> System.out.println(o));
			System.out.println("=====");
			int sum = list.stream().mapToInt(o -> Integer.parseInt(o)).sum();
			System.out.println(sum);
			sum = list.stream().distinct().mapToInt(o -> Integer.parseInt(o))
					.sum();
			System.out.println(sum);
			sum = list.stream().distinct().filter(o -> o.compareTo("3") > 0)
					.mapToInt(o -> Integer.parseInt(o)).sum();
			System.out.println(sum);
			System.out.println("=====");
		}
	}

	public static void FunctionExTest() {
		String otherThing = "no thing is other thing";
		Consumer<List<String>> myConsumer = (y) -> {
			System.out.println("do function thing in other class");
			System.out
					.println("do function thing in other class = " + y.get(0));
			System.out.println("do function = " + otherThing);
		};
		new FunctionEx().run(myConsumer);
	}

	/**
	 * 和C#的delegate委任差不多 只要把Function丟出去，別人就call function就好，不需要再call你本class的其它東西
	 * 例如A class為dao , B class為busincess，dao就開了1個可傳function的東西進來
	 * dao就可以做一邊做A的事完後再call b的function，「如同做了一個介面{物件}的東西傳了進去給dao執行」
	 * 好處是少做了介面還比較容易修改
	 * */
	static class FunctionEx {
		// 用來測試lembda來實作interface,要怎麼做到interface有2個函數要再看看
		interface interFaceTest {
			int add(int a, int b);
		}

		public void run(Consumer<List<String>> function) {
			System.out.println("do mything");
			ArrayList<String> list = new ArrayList<>();
			list.add(" buy ");
			list.add(" sell ");
			list.add(" buy and sell ");
			function.accept(list);
			System.out.println("do mything end");
			interFaceTest a = (x, y) -> x + y;
			System.out.println("" + a.add(33, 44));
			run2((int x, int y) -> x + y);
			//斷言，我覺得和strema().filter是一樣的東西，它有一個.test可用匿名(T a)->T.xxxxx....去寫，就少寫一個介面而已
			//Predicate<T>
			
			//Function<T1, T2>
		}

		public void run2(interFaceTest a) {
			System.out.println("" + a.add(11, 22));
		}

	}
}
