package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }

    public T max() {
        if (this.size() == 0) {
            return null;
        }
        T max = this.get(0);

        for (int i = 1; i < this.size(); i++) {
            T currentItem = this.get(i);
            if (comparator.compare(max, currentItem) < 1) {
                max = currentItem;
            }
        }

        return max;
    }

    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        }

        T max = this.get(0);

        for (int i = 1; i < this.size(); i++) {
            T currentItem = this.get(i);
            if (c.compare(max, currentItem) < 1) {
                max = currentItem;
            }
        }

        return max;
    }
}
