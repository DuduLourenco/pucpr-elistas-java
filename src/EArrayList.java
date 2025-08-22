import java.util.Objects;

public class EArrayList<T> {
    private T[] data;
    private int capacity;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public EArrayList() {
        this.capacity = 16;
        this.data = (T[]) new Object[this.capacity];
    }

    @SuppressWarnings("unchecked")
    public EArrayList(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[this.capacity];
    }

    private int getNextInsertIndex() {
        for (int i = 0; i < this.data.length; i++) {
            if(this.data[i] == null) {
                return i;
            }
        }

        return -1;
    }

    private void isIndexInBounds(int index) {
        boolean isIndexOutBounds = index < 0 || index >= size;
        if(isIndexOutBounds) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isIndexFilled(int index) {
        return this.data[index] != null;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        int capacity = this.data.length;
        int newCapacity = (int) (capacity * 2);

        T[] resizedData = (T[]) new Object[newCapacity];

        for (int i = 0; i < capacity; i++) {
            resizedData[i] = this.data[i];
        }

        this.capacity = newCapacity;
        this.data = resizedData;
    }

    private void moveItemsForNextIndex(int index) {
        T[] originalData = data;
        for (int i = index; i < originalData.length; i++) {

        }
    }

    public void add(T element) {
        if(size == this.data.length) {
            grow();
        }

        this.data[size] = element;
        size = size + 1;
    }

    public void add(int index, T element) {
        this.isIndexInBounds(index);
        if(size == this.data.length) {
            grow();
        }

        if(this.data[index] != null) {
            for (int i = index + 1; i < this.data.length; i++) {
                this.data[i] = this.data[i - 1];
            }
        }

        this.data[index] = element;
        size = size + 1;
    }

    public T set(int index, T element) {
        this.isIndexInBounds(index);

        T oldElement = this.data[index];
        this.data[index] = element;
        return oldElement;
    }

    public T get(int index) {
        this.isIndexInBounds(index);

        return this.data[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i <= size; i++) {
            if(Objects.equals(this.data[i], element)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public T[] toArray() {
        return this.data;
    }
}
