package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    private static void tester(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int size){
        AList nItemsAList = new AList();

        Stopwatch sw = new Stopwatch();
        for(int i = 0; i < size; i++){
            nItemsAList.addLast(i);
        }
        double nItemsAListElapsedTime = sw.elapsedTime();

        Ns.addLast(size);
        times.addLast(nItemsAListElapsedTime);
        opCounts.addLast(size);
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        AList Ns = new AList();
        AList times = new AList();
        AList opCounts = new AList();

        tester(Ns, times, opCounts, 1000);
        tester(Ns, times, opCounts, 2000);
        tester(Ns, times, opCounts, 4000);
        tester(Ns, times, opCounts, 8000);
        tester(Ns, times, opCounts, 16000);
        tester(Ns, times, opCounts, 32000);
        tester(Ns, times, opCounts, 64000);
        tester(Ns, times, opCounts, 128000);
        tester(Ns, times, opCounts, 256000);
        tester(Ns, times, opCounts, 512000);
        tester(Ns, times, opCounts, 1000000);
        tester(Ns, times, opCounts, 2000000);
        tester(Ns, times, opCounts, 4000000);
        tester(Ns, times, opCounts, 8000000);
        tester(Ns, times, opCounts, 16000000);



        printTimingTable(Ns, times, opCounts);
    }
}
