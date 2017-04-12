/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public class LinkedList<T> {
    private int length;
    private Node<T> head;


    public LinkedList() {
        length = 0;
        head = null;
    }


    public int getLength() {
        return length;
    }


    public boolean isEmpty() {
        return length == 0;
    }


    private class Node<T> {
        private T data;
        private Node<T> next;


        private Node(T dataPortion) {
            this(null, dataPortion);
        }


        private Node(Node<T> nextNode, T newData) {
            data = newData;
            next = nextNode;
        }


        private void setData(T newData) {
            data = newData;
        }


        private T getData() {
            return data;
        }


        private void setNext(Node<T> nextNode) {
            next = nextNode;
        }


        private Node<T> getNext() {
            return next;
        }
    }
}
