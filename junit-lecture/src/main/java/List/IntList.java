package List;

public class IntList {
    int first = 0;
    IntList rest = null;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if(this.rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int get(int i){
        if(i == 0){
            return this.first;
        }
        return rest.get(i - 1);
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x){
        if (L == null){
            return null;
        }
        return new IntList(L.first + x, incrList(L.rest, x));
    }



    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return null;
        }
        L.first = L.first + x;
        L.rest = dincrList(L.rest, x);
        return L;
    }


    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        IntList newList = incrList(L, 3);
        IntList dincrList = dincrList(L, 5);

        // System.out.println(L.size());
        // System.out.println(L.get(3));
//         System.out.println(newList.size());
         System.out.println(L.get(0) + " " + dincrList.get(0));
         System.out.println(L.get(1) + " " + dincrList.get(1));
         System.out.println(L.get(2) + " " + dincrList.get(2));




    }
}