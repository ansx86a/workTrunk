package mockito;

import java.util.LinkedList;
import java.util.List;

import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

public class Mockito基本應用 {

	/**
	 * <pre>
	 * http://static.javadoc.io/org.mockito/mockito-core/2.9.0/org/mockito/Mockito.html#0
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mockito基本應用 m = new Mockito基本應用();
		m.$1最基本的mock和verify();
		// m.$2設定物件的return和丟例外();

	}

	/**
	 * <pre>
	 * mock 一個類別，你可以對這個類別做任何事，但不會有反應
	 * 反應和return要另外寫(ex: Mockito.when)
	 * 最後可以用verify去驗証，這個物件那個method被執行了幾次，保証有被呼叫過
	 * </pre>
	 */
	public void $1最基本的mock和verify() {
		List mockedList = Mockito.mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.add("one");
		// ↑↑這裡的mockedList裡面的內容仍然是空的
		// ↑↑主要是說mockedList做的操作，事後只能用verify來驗証
		mockedList.clear();

		// verification
		Mockito.verify(mockedList).clear();
		Mockito.verify(mockedList, Mockito.times(2)).add("one");
		System.out.println("過了2次驗証，換做1次的驗証，應該要丟exception");
		Mockito.verify(mockedList).add("one");// 這一行因為次數的關系會出錯，預設是1次
		Mockito.verify(mockedList).add("two");// 這一行因為沒下過會出錯
		// ↑↑這裡的verify可以驗証做過的動作
		// ↑↑注意的是，好像只會驗有沒有做過
	}

	public void $2設定物件的return和丟例外() {
		LinkedList mockedList = Mockito.mock(LinkedList.class);
		mockedList.add("1");
		mockedList.add("2");
		mockedList.add("3");
		Mockito.when(mockedList.get(0)).thenReturn("mock設好的return值");
		Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException("mock設好的例外"));

		System.out.println(mockedList.get(0));
		System.out.println(mockedList.get(2));// 就算有用list確實add東西，仍然不會進物件，這裡會回傳null
		System.out.println(mockedList.get(999));// 沒有設的東西會回傳null

		Mockito.verify(mockedList).get(0);

		System.out.println(mockedList.get(1));// 這裡會丟例外，所以放在最後面
	}

}
