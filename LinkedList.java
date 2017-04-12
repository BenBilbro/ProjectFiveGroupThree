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


    public void add(T entry) {
        Node<T> newNode = new Node<T>(entry) {
        newNode.next = head;
        
        head = newNode;
        length++;
            
        }
    }


    public T getEntry(int index) {
        Node<T> curr = head;
        if (index >= 1 && index < size) {
            int currentIndex = 0;
            T data = null;
            while (curr != null) {
                if (currentIndex == index) {
                    data = curr.data;
                }
                currentIndex++;
                curr = curr.next;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    private class Node {
        private T data;
        private Node<T> next;


        private Node(T dataPortion) {
            this(dataPortion, null);
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


        private void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }


        private Node<T> getNextNode() {
            return next;
        }
    }
}
