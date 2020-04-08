/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 23 - BinNode class
 */

// TODO: implement the BinNode<T> class
public class BinNodeSol<T> {

    private T  data;
    private BinNodeSol<T> left, right;

    public BinNodeSol() {
        data = null;
        left = right = null;
    }

    public BinNodeSol(T data) {
        this.data = data;
        left = right = null;
    }

    public T getData() {
        return data;
    }

    public BinNodeSol<T> getLeft() {
        return left;
    }

    public BinNodeSol<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinNodeSol<T> left) {
        this.left = left;
    }

    public void setRight(BinNodeSol<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String str = "";
        if (left == null)
            str += "-";
        str += data;
        if (right == null)
            str += "-";
        return str;
    }
}