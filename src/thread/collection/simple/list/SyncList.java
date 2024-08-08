package thread.collection.simple.list;

import java.util.Arrays;

import static util.ThreadUtils.sleep;

public class SyncList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementDate;
    private int size = 0;

    public SyncList() {
        elementDate = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object e) {
        elementDate[size] = e;
        sleep(100);
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return elementDate[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elementDate, size))
                + " size = " + size + ", capacity = " + elementDate.length;
    }
}
