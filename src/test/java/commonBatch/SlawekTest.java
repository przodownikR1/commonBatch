package commonBatch;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
@Slf4j
public class SlawekTest {
    

    @SuppressWarnings("boxing")
    @Test
    public void test() {
        @SuppressWarnings("unchecked")
        List<Integer> myMockedList = mock(ArrayList.class);
        when(myMockedList.get(anyInt())).thenReturn(5);
        when(myMockedList.isEmpty()).thenReturn(false);
        log.info("{} ", myMockedList.get(1));
        log.info("{} ", myMockedList.isEmpty());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test2() {
        List<String> myMockedList = mock(List.class);
        when(myMockedList.get(0)).thenReturn("target").thenReturn("others");
        // when(myMockedList.get(0)).thenReturn("target", "others", "more");

        log.info(myMockedList.get(0));
        log.info(myMockedList.get(0));
        log.info(myMockedList.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void throwException() {
        @SuppressWarnings("unchecked")
        List<String> myMockedList = mock(ArrayList.class);

        when(myMockedList.get(anyInt())).thenThrow(new NullPointerException());
        doThrow(new RuntimeException()).when(myMockedList).clear();

        log.info("{}", myMockedList.get(1));
        myMockedList.clear();
    }

    @Test
    public void stubbedMethod() {
        @SuppressWarnings("unchecked")
        List<Integer> myMockedList = mock(List.class);

        myMockedList.get(0);
        myMockedList.clear();

        verify(myMockedList).get(0);
        verify(myMockedList).clear();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void stubbed2() {
        List myMockedList = mock(List.class);
        myMockedList.clear();
        myMockedList.get(0);
        myMockedList.get(1);
        myMockedList.add("a");
        myMockedList.add("b");
        myMockedList.add("c");
        verify(myMockedList).clear();
        verify(myMockedList, times(1)).clear();
        verify(myMockedList, times(2)).get(anyInt());
        verify(myMockedList, times(3)).add(anyObject());
        verify(myMockedList, never()).remove(anyObject());
        verify(myMockedList, atLeast(2)).add(anyObject());
        verify(myMockedList, atMost(1)).clear();
    }
    
    @Test
    public void stubbed4() {
        
        
    }

    @Test(timeout = 120)
    public void testTransactTimeout() {
        try {
            Thread.sleep(100); // Placeholder code for a network activity with latency
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}
