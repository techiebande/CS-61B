package deque;


import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void sizeTest(){
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        assertEquals(0, adq.size());
    }

    @Test
    public void addFirstTest(){
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        for(int i = 0; i < 10000; i++){
            adq.addFirst(i);
        }

        assertEquals(10000,adq.size());
    }

    @Test
    public void addLastTest() {
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        adq.addLast(33);

        assertEquals(1, adq.size());

        adq.addLast(28);
        adq.addLast(238);
        adq.addLast(2128);
        adq.addLast(3528);

        assertEquals(5, adq.size());
    }

    @Test
    public void isEmptyTest(){
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        assertTrue(adq.isEmpty());

        adq.addLast(3);

        assertFalse(adq.isEmpty());
    }

    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        adq.addLast(4);
        adq.addFirst(14);

        int first = adq.removeFirst();

        assertEquals(14, first);

        first = adq.removeFirst();
        assertEquals(4, first);
    }

    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        for(int i = 0; i < 10000; i++){
            adq.addFirst(i);
        }

        for(int i = 0; i < 9999; i++){
            adq.removeLast();
        }

        int last = adq.removeLast();

        assertEquals(9999, last);
    }

    @Test
    public void getTest(){
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        adq.addLast(23);
        adq.addFirst(37);
        adq.addLast(89);

        int second = adq.get(1);
        int third = adq.get(2);

        assertEquals(23, second);
        assertEquals(89, third);

        ArrayDeque<Integer> adq2 = new ArrayDeque<>();
        assertEquals(null, adq2.get(0));

    }
}
