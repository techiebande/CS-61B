package deque;

public class LinkedListDeque<T> {

    private class TNode{
        public T item;
        public TNode prev;
        public TNode next;

        private TNode(T x, TNode n, TNode p){
            item = x;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(T x){
        TNode newNode = new TNode(x, null, null);
        sentinel = new TNode(null, newNode, newNode);
        newNode.next = sentinel;
        newNode.prev = sentinel;
    }

    public void addFirst(T x){
        TNode first = sentinel.next;
        TNode newNode = new TNode(x, first, sentinel);
        sentinel.next = newNode;
        size += 1;
        first.prev = newNode;
    }

    public void addLast(T x){
        TNode last = sentinel.prev;
        TNode newNode = new TNode(x, sentinel, last);
        last.next = newNode;
        size += 1;
        sentinel.prev = newNode;
    }
    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }

    public int size() {
        return size;
    }

    /** private helper method to recursively print the items of the deque */
    private void printDeque(TNode list){
        if(list.item != null){
            System.out.print(list.item + " ");
        }
        if(list.next == sentinel){
            System.out.println();
            return;
        }
        printDeque(list.next);
    }

    public void printDeque(){
        printDeque(sentinel.next);
    }

    public T removeFirst(){
        if(size > 0){
            TNode first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            size -= 1;
            return first.item;
        }else {
            return null;
        }
    }

    public T removeLast(){
        if(size > 0){
            TNode last = sentinel.prev;
            sentinel.prev = last.prev;
            last.prev.next = sentinel;
            size -= 1;
            return last.item;
        }else {
            return null;
        }
    }

    public T get(int index){
        if(size < 1 || index >= size){
            return null;
        }

        TNode list = sentinel.next;

        for(int i = 0; i < size; i++){
            if(i == index){
                return list.item;
            }
            list = list.next;
        }

        return null;
    }

    /** private helper method to recursively get an item at a given index  */
    private T getRecursive(int index, int count, TNode list){
        if(index == count){
            return list.item;
        }
        return getRecursive(index, 1 + count, list.next);
    }

    public T getRecursive(int index){
        if(size < 1 || index >= size){
            return null;
        }
        return getRecursive(index, 0, sentinel.next);
    }
}
