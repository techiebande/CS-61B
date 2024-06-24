package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    private static void tester(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int N){
        SLList<Integer> list = new SLList<>();

        for(int i = 0; i < N; i++){
            list.addFirst(i);
        }

        Stopwatch sw = new Stopwatch();

        for(int i = 0; i < 10000; i++){
            list.getLast();
        }

        double elapsedTime = sw.elapsedTime();

        Ns.addLast(N);
        times.addLast(elapsedTime);
        opCounts.addLast(10000);
    }

    public static void timeGetLast() {
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


        printTimingTable(Ns, times, opCounts);
    }

}
