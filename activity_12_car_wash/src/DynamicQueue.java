public class DynamicQueue<T> {

    private Node<T> front, rear;

    public DynamicQueue() {
        front = rear = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null) {
            front = rear = newNode;
        }
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public T pop() {
        if (isEmpty())
            return null;
        T data = front.getData();
        Node<T> temp = front;
        front = front.getNext();
        temp.setNext(null);
        if (front == null)
            rear = null;
        return data;
    }

    public T peek() {
        if (isEmpty())
            return null;
        return front.getData();
    }

    public int size() {
        int count = 0;
        Node<T> current = front;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String toString() {
        String out = "(front)";
        Node<T> current = front;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (rear)";
        return out;
    }
}