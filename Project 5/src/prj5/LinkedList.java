/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * This class is meant be the linked implementation of a list
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 * @param <T>
 *            The generic type
 */
public class LinkedList<T> implements Iterable<T> {

    private int length;
    private Node<T> head;
    private Node<T> tail;


    /**
     * Creates a new LinkedList
     */
    public LinkedList() {
        clear();
    }


    /**
     * Gets the number of elements in the linked list
     * 
     * @return the number of elements in the list
     */
    public int getLength() {
        return length;
    }


    /**
     * Checks if the list is empty by checking if the length is 0
     * 
     * @return True if empty, false if not
     */
    public boolean isEmpty() {
        return length == 0;
    }


    /**
     * Only adds an element to the linked chain if the entry is not null
     * 
     * @param anEntry
     *            The specified element to be added to the list
     */
    public void add(T anEntry) {
        if (anEntry != null) {
            Node<T> newNode = new Node<T>(anEntry);
            // If the list is empty the head and tail can be set to the same
            // node, only the tail needs to be changed
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = tail.next;
            }
            length++;
        }
    }


    /**
     * Removes all elements from the linked chain and resets the length to 0
     */
    public void clear() {
        length = 0;
        head = null;
        tail = null;
    }


    /**
     * Creates and returns an array of every element in the linked list
     * 
     * @return an array of all of the elements in the list
     */
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        Object[] toArr = (T[])new Object[getLength()];
        int i = 0; // index for nodes
        Node<T> curr = head;
        while (curr != null) {
            toArr[i] = curr.data;
            curr = curr.next;
            i++;
        }
        return toArr;

    }


    /**
     * Creates a new Iterator for the linked list
     * 
     * @param index
     *            The point at which the iterator will begin in the list
     * @return an Iterator that will traverse a list with the generic type T
     *         element
     */
    public Iterator<T> iteratorIndex(int index) {
        return new ListIterator(index);
    }


    /**
     * Creates a new Iterator for the linked list
     * 
     * @return an Iterator that will traverse a list with the generic type T
     *         element
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    /**
     * This class contains the implementation for iterating through the linked
     * list
     * 
     * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
     */
    private class ListIterator implements Iterator<T> {

        private Node<T> current;


        /**
         * Creates a new ListIterator
         */
        public ListIterator() {
            this(0);

        }


        /**
         * Creates a new ListIterator starting at a certain point in the list
         * 
         * @param index
         *            The starting point of the iterator
         */
        public ListIterator(int index) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }


        /**
         * Checks if the traversal has reached the end of the list
         * 
         * @return True if there are more elements ahead, false if not
         */
        @Override
        public boolean hasNext() {
            return current != null;

        }


        /**
         * Iterates once through the list, storing the data in the Node
         * 
         * @return The data in the Node
         */
        @Override
        public T next() {
            // saves data to a temp variable.
            T temp = current.data;
            current = current.next;
            return temp;

        }

    }


    /**
     * This class contains the implementation for the Node, which will store the
     * data and a reference to the next node in the data structure
     * 
     * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
     *
     * @param <T>
     *            The generic type
     */

    private class Node<E> {
        private T data;
        private Node<T> next;


        /**
         * Creates a Node that stores the data into it with a reference of null
         * for the next node
         * 
         * @param dataPortion
         *            The data to be stored in the node
         */
        private Node(T dataPortion) {
            this(dataPortion, null);
        }


        /**
         * Creates a new Node with data and a reference to the next Node
         * 
         * @param newData
         *            the data to be stored in the node
         * @param nextNode
         *            the reference to the next node in the list
         */
        private Node(T newData, Node<T> nextNode) {
            data = newData;
            next = nextNode;
        }

    }

}
