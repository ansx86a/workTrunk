package mockito;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import org.mockito.internal.matchers.Contains;
import org.mockito.internal.matchers.GreaterThan;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * http://static.javadoc.io/org.mockito/mockito-core/2.23.4/org/mockito/Mockito.html#0
 */
public class Mockito基本例子 {

    @Test
    public void 最基本的例子_mock介面和驗証() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
        verify(mockedList).add("one");//重覆驗証會過
        verify(mockedList).clear();//重覆驗証會過
        try {
            Mockito.verify(mockedList, Mockito.times(2)).add("one");
        } catch (TooLittleActualInvocations ex) {
            System.out.println("次數驗証有問題");
        }
    }

    /**
     * 所謂的stub就是有一些service，ex: getDbDataXXX，你不想真的去捉DB<br>
     * 而是去弄一個假的回傳測試值就是stub
     */
    @Test
    public void 產生stub() {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));//First
        System.out.println(mockedList.get(999));//null
        try {
            mockedList.get(1);
        } catch (Exception ex) {
            System.out.println("預期的Exception stub");
        }
    }

    @Test
    public void 匹配參數的stub() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("element");
        when(mockedList.contains(argThat(isValid()))).thenReturn(true);//客製匹配
        when(mockedList.contains(argThat(o -> o instanceof Date))).thenReturn(true);//客製匹配

        System.out.println(mockedList.get(999));//element
        System.out.println(mockedList.contains("123"));//true
        System.out.println(mockedList.contains(new Date()));//true
        System.out.println(mockedList.contains("456"));//false，因為boolean沒有null
        verify(mockedList).get(anyInt());//目前沒試出int的改寫方法


        verify(mockedList).contains(argThat(isValid()));//Object的改寫方法
        verify(mockedList).contains(argThat(o -> o instanceof Date));

        //註解：當有一個參數使用匹配就要全部的參數都用匹配，不能只用一半
        //verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));

    }

    private ArgumentMatcher<String> isValid() {
        return new Contains("123");//這個可以用ArgumentMatcher的Type hierarchy來看，蠻清楚的
    }

    @Test
    public void verify的次數設定() {
        List mockedList = mock(List.class);
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");//沒寫等於1次
        verify(mockedList, times(1)).add("once");
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("never happened");//0次

        verify(mockedList, atLeastOnce()).add("three times");//至少一次
        verify(mockedList, atLeast(2)).add("three times");//至少n次
        verify(mockedList, atMost(5)).add("three times");//最多n次
    }

    @Test
    public void verify有順序性的寫法_一反向驗証就掛點() {
        List singleMock = mock(List.class);

        singleMock.add("was added first");
        singleMock.add("was added second");

        InOrder inOrder = inOrder(singleMock);
        inOrder.verify(singleMock).add("was added first");//這行註解沒有影嚮
        inOrder.verify(singleMock).add("was added second");//主要是順向驗証就好，可以跳號
        try {
            inOrder.verify(singleMock).add("was added first");//這行出EX就結束程式了，所以註解一下
        } catch (Throwable ex) {
            System.out.println("不可逆向驗証");
        }

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first1");
        firstMock.add("was called first2");
        secondMock.add("was called second1");
        secondMock.add("was called second2");

        InOrder inOrder2 = inOrder(firstMock, secondMock);

        inOrder2.verify(firstMock).add("was called first1");//一樣要照順序
        //inOrder2.verify(firstMock).add("was called first2");

        //inOrder2.verify(secondMock).add("was called second1");
        inOrder2.verify(secondMock).add("was called second2");//而且兩個mock不能對調
    }

    @Test
    public void verify使用過的stub全有驗証() {
        List mockOne = mock(List.class);

        mockOne.add("one");
        verify(mockOne).add("one");
        verify(mockOne, never()).add("two");
        verifyZeroInteractions(mockOne);
        verifyNoMoreInteractions(mockOne);
        mockOne.add("two");
        verify(mockOne).add("two");
        //兩個一樣的東西，不過命名不一樣，大概zero是要確認是沒被用過，而noMore是有用過的分別吧，不過沒差
        verifyZeroInteractions(mockOne);  //MOCKITO_CORE.verifyNoMoreInteractions(mocks);
        verifyNoMoreInteractions(mockOne);//MOCKITO_CORE.verifyNoMoreInteractions(mocks);
        mockOne.add("two");
        verify(mockOne, times(2)).add("two");
        verifyZeroInteractions(mockOne);
        verifyNoMoreInteractions(mockOne);
        mockOne.add("two");
        try {
            verifyZeroInteractions(mockOne);//
        } catch (Throwable ex) {
            System.out.println("有stub被call了沒有驗証的情況發生");
        }
    }

    @Test
    public void 產生stub的另一種寫法_針對Exception() {
        List mockedList = mock(List.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        try {
            mockedList.clear();
        } catch (RuntimeException ex) {
            System.out.println("產生Exception stub");
        }
    }
}
