package List;
/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within */

public class SLList<LochNess> {
    private class TypeNode {
        public LochNess item;
        public TypeNode next;

        public TypeNode(LochNess i, TypeNode n){
            item = i;
            next = n;
        }
    }

    /* The first item if it exists, is at sentinel.next */
    private TypeNode sentinel;
    private int size;

    public SLList() {
        sentinel = new TypeNode(null, null);
        size = 0;
    }
    public SLList(LochNess x){
        sentinel = new TypeNode(x, null);
        sentinel.next = new TypeNode(x, null);
        size = 1;
    }

    /* Adds x to the front of the list. */
    public void addFirst(LochNess x){
        sentinel.next = new TypeNode(x, sentinel.next);
        size += 1;
    }

    /* Returns the first item in the list */
    public LochNess getFirst(){
        return sentinel.next.item;
    }

    private void addLast(TypeNode first, LochNess x){
        if (first.next == null){
            first.next = new TypeNode(x, null);
        }else {
            addLast(first.next, x);
        }
    }

    /* Adds an item to the end of the list */
    public void addLast(LochNess x){
        if(size > 0){
            size += 1;
            addLast(sentinel.next, x);
        }else {
            addFirst(x);
            size += 1;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args){
        SLList<Integer> L = new SLList<>();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(100);
        L.addLast(900);
        L.addLast(300);

        System.out.println(L.size());


        SLList<String> StringL = new SLList<>();
        StringL.addFirst("obande");
        StringL.addFirst("ochaba");
        StringL.addFirst("samuel");

        System.out.println(StringL.getFirst());
        System.out.println(StringL.size());


    }
}
