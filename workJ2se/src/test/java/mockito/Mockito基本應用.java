package mockito;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Contains;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * <pre>
 * http://static.javadoc.io/org.mockito/mockito-core/2.9.0/org/mockito/Mockito.html#0
 * </pre>
 */
public class Mockito基本應用 {

	/**
	 * <pre>
	 * 要讓annoation生效有3種方法
	 * 1. 注意要有MockitoAnnotations.initMocks(testClass);
	 * 2.在Mockito基本應用加上 @RunWith(MockitoJUnitRunner.StrictStubs.class)
	 * 3.在物件變數中加入@Rule public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
	 * </pre>
	 */
	@Mock
	private List mlist;

	public Mockito基本應用() {
		MockitoAnnotations.initMocks(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mockito基本應用 m = new Mockito基本應用();
		// m.$1最基本的mock和verify();
		// m.$2設定物件的return和丟例外();
		// m.$3用pattern來假裝傳入值並設定回傳值();
		// m.$4Verify的times的寫法();
		// m.$5Verify需要控制順序的寫法();
		// m.$6Verify();
		// m.$7測試annoation和return控制();
		// m.$8return相關();
		// m.$9spy一個已存在的物件();
		m.$10補捉mock參數();
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
		System.out.println(mockedList.get(0));// 就算上面有add，是假的，這裡仍然是null
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

	/**
	 * <pre>
	 * mock 一個類別，你可以對這個類別做任何事，但不會有反應
	 * 這裡就是要讓他有反應，例如會丟exception，或是有return值
	 * </pre>
	 */
	public void $2設定物件的return和丟例外() {
		LinkedList mockedList = Mockito.mock(LinkedList.class);
		mockedList.add("1");
		mockedList.add("2");
		mockedList.add("3");
		Mockito.when(mockedList.get(0)).thenReturn("mock設好的return值");
		Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException("mock設好的例外"));
		// 反方向的寫法
		Mockito.doThrow(new RuntimeException("mock設好的例外2")).when(mockedList).get(111);

		System.out.println(mockedList.get(0));
		System.out.println(mockedList.get(2));// 就算有用list確實add東西，仍然不會進物件，這裡會回傳null
		System.out.println(mockedList.get(999));// 沒有設的東西會回傳null

		Mockito.verify(mockedList).get(0);

		System.out.println(mockedList.get(111));// 這裡會丟例外，所以放在最後面
		System.out.println(mockedList.get(1));// 這裡會丟例外，所以放在最後面
	}

	/**
	 * <pre>
	 * mock 一個類別，你可以對這個類別做任何事，但不會有反應
	 * 這裡是讓傳被去的參數為一個pattern，可以吃的範圍會比較大
	 * </pre>
	 */
	public void $3用pattern來假裝傳入值並設定回傳值() {
		List<String> mockedList = Mockito.mock(List.class);
		Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn("element");

		// Mockito.when(mockedList.contains(Mockito.argThat(isValid()))).thenReturn("element");//這一行不懂先跳過

		// 這一行是可以檢查傳入的參數有沒有包含123的字串，可參照mockito已實作的ArgumentMatcher
		Mockito.when(mockedList.contains(Mockito.argThat(new Contains("123")))).thenReturn(true);
		// 這一行是客制化參數的寫法，讓List的泛型T型別可以檢查
		// 前面的參數不能直接用int了，怪怪，好像要就全用mockito.xxxx，不然就全用object
		/**
		 * Warning on argument matchers: If you are using argument matchers, all
		 * arguments have to be provided by matchers.
		 * 
		 * <pre>
		 * verify(mock).someMethod(anyInt(), anyString(), "third argument");
		 * 上面那行會錯，所以要改成下一行
		 * verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
		 * </pre>
		 */
		// 全塞object的會優先被選擇出來
		Mockito.when(mockedList.set(Mockito.anyInt(), Mockito.argThat(new 檢查String長度等於2()))).thenReturn("回傳string");
		Mockito.when(mockedList.set(99, "99")).thenReturn("5566");

		System.out.println(mockedList.get(999));
		System.out.println(mockedList.contains("ddd"));
		System.out.println(mockedList.contains("123"));
		System.out.println(mockedList.set(1, "長度3"));
		System.out.println(mockedList.set(1, "長2"));
		System.out.println(mockedList.set(1, "xxx"));
		System.out.println(mockedList.set(99, "99"));

		// you can also verify using an argument matcher
		Mockito.verify(mockedList).get(Mockito.anyInt());

		mockedList.add("為了下面的verify要新增一筆，怪的是when試不出lambda但是下面的verify就可以");
		// argument matchers can also be written as Java 8 Lambdas
		Mockito.verify(mockedList).add(Mockito.argThat(someString -> someString.length() > 1));

	}

	static class 檢查String長度等於2 implements ArgumentMatcher<String> {
		public boolean matches(String s) {
			if (s.length() == 2)
				return true;
			return false;
		}

		public String toString() {
			// printed in verification errors
			return "[檢查String長度等於2]";
		}
	}

	public void $4Verify的times的寫法() {
		List<String> mockedList = Mockito.mock(List.class);

		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// 預設times是1次
		Mockito.verify(mockedList).add("once");
		Mockito.verify(mockedList, Mockito.times(1)).add("once");
		Mockito.verify(mockedList, Mockito.times(2)).add("twice");
		Mockito.verify(mockedList, Mockito.times(3)).add("three times");

		// 和times(0)相同
		Mockito.verify(mockedList, Mockito.never()).add("never happened");

		// 至少n次和至多n次的寫法
		Mockito.verify(mockedList, Mockito.atLeastOnce()).add("three times");
		Mockito.verify(mockedList, Mockito.atLeast(2)).add("three times");
		Mockito.verify(mockedList, Mockito.atMost(5)).add("three times");
	}

	public void $5Verify需要控制順序的寫法() {
		List singleMock = Mockito.mock(List.class);

		singleMock.add("was added first");
		singleMock.add("was added second");
		InOrder inOrder = Mockito.inOrder(singleMock);
		// 要依順序firsr到second，不然會出錯，這裡就是在控順序的
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");

		List firstMock = Mockito.mock(List.class);
		List secondMock = Mockito.mock(List.class);

		// 把2個mock看成1個mock，其它可以加到n個都行
		firstMock.add("was called 1-1");
		secondMock.add("was called 2-1");
		firstMock.add("was called 1-2");
		secondMock.add("was called 2-2");

		inOrder = Mockito.inOrder(firstMock, secondMock);
		inOrder.verify(firstMock).add("was called 1-1");
		inOrder.verify(secondMock).add("was called 2-1");
		inOrder.verify(firstMock).add("was called 1-2");
		inOrder.verify(secondMock).add("was called 2-2");

	}

	public void $6Verify() {
		List<String> mockedList = Mockito.mock(List.class);
		List<String> mockedList2 = Mockito.mock(List.class);

		mockedList.add("one");
		mockedList.add("two");

		Mockito.verify(mockedList).add("one");
		Mockito.verify(mockedList).add("two");
		// 下面這一行不太懂，用下去和下下行一樣，先這樣吧
		// Mockito.verifyZeroInteractions(mockedList);

		// 下面會因為有沒有verify到的東西而產生錯誤
		Mockito.verifyNoMoreInteractions(mockedList);

	}

	public void $7測試annoation和return控制() {
		mlist.clear();
		// verification
		Mockito.verify(mlist).clear();

		// 說明回傳順序for多個return_包含exception:{Mockito.when(mlist.get(1)).thenThrow(new
		// RuntimeException()).thenReturn("foo");}

		// 最後一個return會持續
		Mockito.when(mlist.get(1)).thenReturn("one").thenReturn("two", "three");
		System.out.println(mlist.get(1));
		System.out.println(mlist.get(1));
		System.out.println(mlist.get(1));
		System.out.println(mlist.get(1));
		System.out.println(mlist.get(1));
	}

	public void $8return相關() {
		// 官網不建議用answer，叫你用簡單的doReturn()|doThrow()| doNothing()
		Mockito.when(mlist.get(1)).thenAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				Object mock = invocation.getMock();
				return "called with arguments: " + Arrays.toString(args);
			}
		});
		System.out.println(mlist.get(1));

		/**
		 * <pre>
		 * 有以下這幾項可以用
		 * doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() family of methods
		 * </pre>
		 */
		Mockito.doReturn("999").when(mlist).get(111);
		System.out.println(mlist.get(111));

		// 可以自已額制化預設的Mock回傳值，如果沒有用when then return時就會用到
		// 覺得用不太到，要用再學吧
		List mock = Mockito.mock(List.class, Mockito.RETURNS_SMART_NULLS);
		List mockTwo = Mockito.mock(List.class, new Answer() {
			public Object answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				Object mock = invocation.getMock();
				return "我自已客制化的return called with arguments: " + Arrays.toString(args);
			}
		});
		System.out.println(mock.get(135));
		System.out.println(mock.get(579));
		System.out.println(mockTwo.get(246));
		System.out.println(mockTwo.get(680));
	}

	public void $9spy一個已存在的物件() {
		// 之前的mock都沒有自已new 物件，spy是來mock已經有instance的
		List list = new LinkedList();
		list.add("1");
		List spy = Mockito.spy(list);
		list.add("2");// 這一行不被spy吃
		// 注意，spy後應該是一個新的instance的看法(形容而已不一定正確)，之後都要對spy操作，對list的操作不影嚮spy
		// 特別的是物件特性存在，可以add、get，不像mock只能verify而已(有return 都會為null吧)
		// 不然就要寫when return
		spy.add("one");
		spy.add("two");
		System.out.println(spy.get(0));
		System.out.println(spy.get(1));
		System.out.println(spy.get(2));

		// 可以用mock來覆來物件的動作，真的是叫spy，只在關鍵動手腳
		Mockito.when(spy.get(0)).thenReturn("mock one");
		System.out.println(spy.get(0));
		System.out.println(spy.get(1));
	}

	public void $10補捉mock參數() {
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		
		mlist.add("one");//這裡的add只能用一次，才能capture不出錯
		Mockito.verify(mlist).add(argument.capture());
		System.out.println(argument.getValue().toString());

	}
	// 再來是16

}
