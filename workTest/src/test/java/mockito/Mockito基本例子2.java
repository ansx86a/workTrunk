package mockito;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Mockito基本例子2 {

    @Mock
    private List mockedList;

    @Test
    public void 測試Annotation() {
        MockitoAnnotations.initMocks(this);
        mockedList.add("one");
        mockedList.clear();
        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void 測試Annotation証明了兩個test不交互影嚮() {
        //把initMocks拿掉會有null，就算上面那個先執行也沒屁用，一樣null也就獨立個體了
        MockitoAnnotations.initMocks(this);
        mockedList.add("one");
        mockedList.clear();
        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void 複合多個return順序回傳_重放最後一個值() {
        MockitoAnnotations.initMocks(this);
        when(mockedList.get(anyInt()))
                .thenThrow(new RuntimeException())
                .thenReturn("one").thenReturn("two");//可改成.thenReturn("one", "two");
        try {
            mockedList.get(0);
        } catch (Exception ex) {
            System.out.println("第一次EX");
        }
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
    }

    @Test
    public void 複合多個return順序回傳_重放最後一個組() {
        MockitoAnnotations.initMocks(this);
        when(mockedList.get(anyInt()))
                .thenThrow(new RuntimeException())
                .thenReturn("one", "two");
        try {
            mockedList.get(0);
        } catch (Exception ex) {
            System.out.println("第一次EX");
        }
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
    }

    //再來從例再來從例子11開始
}