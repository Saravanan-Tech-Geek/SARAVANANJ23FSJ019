package edu.disease.asn5;

/**
 * The Class Container.
 *
 * @param <T> the generic type
 */
public class Container<T> {

    /** The items. */
    private Object[] items;

    /**
     * Instantiates a new container.
     *
     * @param items the items
     */
    @SafeVarargs
    public Container(T... items) {
        if (items.length == 0) {
            throw new IllegalArgumentException("At least one argument must be supplied.");
        }
        this.items = items;
    }

    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return items.length;
    }

    /**
     * Gets the.
     *
     * @param index the index
     * @return the t
     */
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

