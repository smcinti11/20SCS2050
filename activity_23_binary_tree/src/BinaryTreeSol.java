/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 23 - BinaryTree class
 */

public class BinaryTreeSol<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTreeSol() {
        root = null;
    }

    // TODO: implement the isEmpty method
    public boolean isEmpty() {
        return root == null;
    }

    // TODO: implement the addRecursively private method
    private BinNode<T> addRecursively(BinNode<T> current, final T data) {

        // TODO: check if current is null, if that is the case, return a new BinNode with the data
        if (current == null)
            return new BinNode<T>(data);

        // TODO: if current is not null...
        else {

            // TODO: if given data is smaller than current data, call addRecursively to the left, making sure to use the method's return to set current's left node
            if (data.compareTo(current.getData()) < 0)
                current.setLeft(addRecursively(current.getLeft(), data));

            // TODO: if given data is greater than current data, call addRecursively to the right, making sure to use the method's return to set current's right node
            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));

            // TODO: don't forget to return current
            return current;
        }
    }

    // TODO: implement the add method
    public void add(final T data) {
        if (isEmpty())
            root = new BinNode<T>(data);
        else
            addRecursively(root, data);
    }

    // TODO: override the toString method using a breadth first tree traversal using a queue of binary nodes
    @Override
    public String toString() {
        Queue<BinNode<T>> queue = new Queue<>();
        BinNode<T> current = root;
        queue.push(current);
        String str = "";
        while (!queue.isEmpty()) {
            current = queue.pop();
            str += current.getData() + " ";
            if (current.getLeft() != null)
                queue.push(current.getLeft());
            if (current.getRight() != null)
                queue.push(current.getRight());
        }
        return str;
    }
}
