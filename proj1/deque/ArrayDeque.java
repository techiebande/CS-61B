package deque;

import java.util.Objects;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private boolean isFull() {
        return size == items.length;
    }

    private void resize(int capacity, String position) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newArray, Objects.equals(position, "back") ? 0 : 1, size);
        items = newArray;
    }

    @Override
    public void addFirst(T x) {

        if (isFull()) {
            resize(size * 2, "front");
        } else {
            T[] newArray = (T[])  new Object[items.length];
            System.arraycopy(items, 0, newArray, 1, size);
            items = newArray;
        }
        items[0] = x;

        size += 1;
    }

    @Override
    public void addLast(T x) {
        if (isFull()) {
            resize(size * 2, "back");
        }
        items[size] = x;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length > 16) {
            if (size < 0.25 * items.length) {
                resize((int) (0.25 * items.length), "back");
            }
        }
        T first = items[0];

        T[] newArray = (T[]) new Object[items.length];
        System.arraycopy(items, 1, newArray, 0, size - 1);
        items = newArray;

        size -= 1;

        return first;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length > 16) {
            if (size < 0.25 * items.length) {
                resize((int) (0.25 * items.length), "back");
            }
        }

        T last = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return last;
    }

    @Override
    public T get(int x) {
        if (size != 0) {
            return items[x];
        }
        return null;
    }
}
