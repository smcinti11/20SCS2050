/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinaryTree class
 * Name(s):
 */

import java.util.Iterator;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    private BinNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private BinNode<T> addRecursively(BinNode<T> current, final T data) {
        if (current == null)
            return new BinNode<T>(data);
        else {
            if (data.compareTo(current.getData()) <= 0)
                current.setLeft(addRecursively(current.getLeft(), data));
            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));
            return current;
        }
    }

    public void add(final T data) {
        if (isEmpty())
            root = new BinNode<T>(data);
        else
            addRecursively(root, data);
    }

    // TODO: implement the recursive inOrder tree traversal method
    private String inOrder(final BinNode<T> current) {
        return "";
    }

    // TODO: implement the toString method based on inOrder tree traversal
    @Override
    public String toString() {
        return "";
    }

    // TODO: implement the clear method
    public void clear() {

    }

    // TODO: implement a binary tree iterator
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}