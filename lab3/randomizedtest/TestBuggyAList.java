package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> buggyList = new BuggyAList<>();
        AListNoResizing<Integer> correctList = new AListNoResizing<>();

        buggyList.addLast(4);
        buggyList.addLast(5);
        buggyList.addLast(6);

        correctList.addLast(4);
        correctList.addLast(5);
        correctList.addLast(6);

        assertEquals(buggyList.size(), correctList.size());

        assertEquals(buggyList.removeLast(), correctList.removeLast());
        assertEquals(buggyList.removeLast(), correctList.removeLast());
        assertEquals(buggyList.removeLast(), correctList.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);

                assertEquals(L.getLast(), buggyL.getLast());

            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggyLSize = buggyL.size();

                assertEquals(size, buggyLSize);
            } else if (operationNumber == 2) {
                // getLast
                if(L.size() > 0){
                    int last = L.getLast();
                    int buggyLLast = buggyL.getLast();

                    assertEquals(last, buggyLLast);
                }
            }else if(operationNumber == 3) {
                // removeLast
                if(L.size() > 0){
                    int last = L.removeLast();
                    int buggyLLast = buggyL.removeLast();

                    assertEquals(last, buggyLLast);
                }
            }
        }
    }
}
