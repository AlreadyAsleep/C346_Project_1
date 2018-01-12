public interface ILinkedList<T> {
    /**
     * Get the next list element
     * @return the next element
     */
    ILinkedList<T> next();

    /**
     * Gets the last element in the list
     * @return the node at the end of the list
     */
    ILinkedList<T> last();

    /**
     * Get the element n elements down the list
     * @param n the number of elements to skip
     * @return the element n away
     */
    ILinkedList<T> after(int n);

    /**
     * Removes the next element (sets null)
     * @return the previously next element
     */
    ILinkedList<T> detach();

    /**
     * Gets the current value
     * @return the current value
     */
    T get();

    /**
     * Sets the value of this node
     * @param value the new value
     */
    void set(T value);

    /**
     * Sets the next element in the list
     * @param next the next element
     */
    void setNext(ILinkedList<T> next);

    /**
     * Sets the next element after this current element
     * @param next the next element
     */
    void append(ILinkedList<T> next);

    /**
     * Adds the current list as the next of newFirst
     * @param newFirst the new head of the list
     */
    void insert(ILinkedList<T> newFirst);
}