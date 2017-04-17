/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public class LinkedList<T> {

    protected int length;
    protected Node<T> head;
    protected Node<T> tail;


    public LinkedList() {
        length = 0;
        head = null;
        tail = null;
    }


    public int getLength() {
        return length;
    }


    public boolean isEmpty() {
        return length == 0;
    }


    public void add(T anEntry) {
        if (anEntry != null) {
            Node<T> newNode = new Node<T>(anEntry);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                length++;
            }
            else {
                tail.next = newNode;
                tail = tail.next;
                length++;
            }
        }
    }


    public void clear() {
        length = 0;
        head = null;
        tail = null;
    }


    public Node<T> getHead() {
        return head;
    }


    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        Object[] toArr = (T[])new Object[getLength()];
        int i = 0;
        Node<T> curr = head;
        while (curr != null && i < getLength()) {
            toArr[i] = curr.getData();
            curr = curr.getNext();
            i++;
        }
        return toArr;

    }


    @SuppressWarnings("hiding")
    protected class Node<T> {
        protected T data;
        protected Node<T> next;


        protected Node(T dataPortion) {
            this(dataPortion, null);
        }


        protected Node(T newData, Node<T> nextNode) {
            data = newData;
            next = nextNode;
        }


        protected void setData(T newData) {
            data = newData;
        }


        protected T getData() {
            return data;
        }


        protected void setNext(Node<T> nextNode) {
            next = nextNode;
        }


        protected Node<T> getNext() {
            return next;
        }
    }

}
