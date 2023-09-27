package exercise;

import java.util.Objects;

class SafetyList {
    // BEGIN
    private int[] array = new int[1];
    private int size;

    public synchronized boolean add(int value) {
        if (array.length == size) {
            int[] oldArray = array;
            array = new int[array.length * 2];

           System.arraycopy(oldArray, 0, array, 0, size);
        }
        array[size++] = value;
        return true;
    }

    public int get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }

    public int getSize() {
        return this.size;
    }
    // END
}
