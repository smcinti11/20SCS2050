/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - CircularLinkedList
 */

package p1;

// In circular linked list, the tail node points to the head. In this particular implementation, nodes carry autogenerated id's.
public class CircularLinkedList {

    private Node head, tail;
    private static int nextId = 0;

    public CircularLinkedList() {
        head = tail = null;
    }

    public CircularLinkedList(int nextId) {
        head = tail = null;
        CircularLinkedList.nextId = nextId;
    }

    // TODO: add a new node with nextId, incrementing nextId after; the new node becomes the tail of the list
    public void append() {

    }

    // TODO: remove the head of the list
    public void remove() {

    }

    public boolean isEmpty() {
        return head == null;
    }

    // TODO: return the number of nodes
    public int size() {
        return -1;
    }

    @Override
    public String toString() {
        String out = "";
        Node current = head;
        while (current != null) {
            out += current.toString() + " ";
            current = current.getNext();
            if (current == head)
                break;
        }
        return out;
    }

    // TODO: if the list is NOT empty, move tail to head and head to the next node
    public void next() {
        if (!isEmpty()) {
            tail = head;
            head = head.getNext();
        }
    }

    // TODO: call next until it founds a node with the given id; otherwise, the list should recirculate back to the original configuration
    public void nextToId(int id) {
        if (!isEmpty()) {
            Node current = head;
            while (true) {
                if (head.getId() == id)
                    break;
                next();
                if (current == head)
                    break;
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
