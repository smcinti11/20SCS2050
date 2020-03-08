/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 16 - DynamicStack class
 */

public class DynamicStack<T> {

    private Node<T> top;

    public DynamicStack() {
        top = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top);
        top = newNode;
    }

    public T pop() {
        if (isEmpty())
            return null;
        T data = top.getData();
        Node temp = top;
        top = top.getNext();
        temp.setNext(null);
        return data;
    }

    public T peek() {
        if (isEmpty())
            return null;
        return top.getData();
    }

    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // top to bottom (left to right)
    @Override
    public String toString() {
        String out = "(top)";
        Node<T> current = top;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (bottom)";
        return out;
    }
}