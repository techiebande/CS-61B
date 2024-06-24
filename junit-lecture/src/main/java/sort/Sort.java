package sort;

public class Sort {
    /** Sorts strings destructively */
    public static void sort(String[] x){
        sort(x, 0);
    }

    private static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    public static int findSmallest (String[] x, int start){
        int smallestIndex = start;
        for (int i = start; i < x.length; i++){
            int cmp = x[i].compareTo(x[smallestIndex]);
            if(cmp < 0){
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static void main(String[] args){
        String[] numbers = {"i", "am", "a", "good", "boy"};

        sort(numbers);

        System.out.println(java.util.Arrays.toString(numbers));
    }
}