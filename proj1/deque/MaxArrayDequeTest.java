package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;


public class MaxArrayDequeTest {


    @Test
    public void maxTest(){
        Comparator<Integer> comparator = Integer::compare;
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(comparator);

        assertNull(deque.max());


        deque.addFirst(43);
        deque.addFirst(493);
        deque.addFirst(243);
        deque.addFirst(7);
        deque.addFirst(13);
        deque.addFirst(2403);

        int max = deque.max();

        assertEquals(2403, max);
    }

    @Test
    public void maxTestWithString() {
        Comparator<String> comparator = (a, b) -> a.compareTo(b);
        MaxArrayDeque<String> deque = new MaxArrayDeque<>(comparator);

        assertNull(deque.max());

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addFirst("d");
        deque.addFirst("e");



        String max = deque.max(comparator);

        assertEquals("e", max);

    }

    @Test
    public void maxWithCompareTest(){
        Comparator<Integer> comparator = (a, b) -> a - b;
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(comparator);

        assertNull(deque.max());

        deque.addFirst(43);
        deque.addFirst(493);
        deque.addFirst(243);

        int max = deque.max(comparator);

        assertEquals(493, max);
    }
}
