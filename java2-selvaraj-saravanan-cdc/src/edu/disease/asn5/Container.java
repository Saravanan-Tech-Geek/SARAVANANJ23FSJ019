package edu.disease.asn5;

public class Container<T> {

    private Object[] items;

    @SafeVarargs
    public Container(T... items) {
        if (items.length == 0) {
            throw new IllegalArgumentException("At least one argument must be supplied.");
        }
        this.items = items;
    }

    public int size() {
        return items.length;
    }

    public T get(int index) {
        if (index < 0 || index >= items.length) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        // Unchecked cast is safe because the constructor enforces type T
        @SuppressWarnings("unchecked")
        T item = (T) items[index];
        return item;
    }

}

