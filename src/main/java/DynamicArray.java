public class DynamicArray<T> {

    private int initialSize;

    private T[] elements;

    private int size = 0;

    public DynamicArray(int initialSize) {
        this.initialSize = initialSize;
        elements = (T[]) new Object[initialSize];
    }

    public void set(int index, T value) {
        elements[index] = value;
    }

    public T get(int index) {
        return elements[index];
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        if (size == initialSize) {
            resize();
        }
        elements[size] = element;
        size++;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[initialSize * 2];
        for (int index = 0; index < size; index++) {
            newArray[index] = elements[index];
        }
        elements = newArray;
        initialSize = initialSize * 2;
    }

    public void insert(int index, T element) {
        if (size + 1 == initialSize) {
            resize();
        }
        for (int _index = size; _index >= index; _index--) {
            elements[_index + 1] = elements[_index];
        }
        elements[index] = element;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void delete(int index) {
        for (int _index = index; _index < size; _index++) {
            elements[_index] = elements[_index + 1];
        }
        size--;
    }
}
