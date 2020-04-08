/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 23 - BinaryTreeDriver class
 */

public class BinaryTreeDriver {

    // TODO: create a binary tree and add the data elements to reproduce the tree described in the lecture about trees; don't forget to print your tree at the end
    public static void main(String[] args) {
        BinaryTree<String> btree = new BinaryTree<>();
        btree.add("Janet");
        btree.add("Alex");
        btree.add("Brenna");
        btree.add("Anthony");
        btree.add("Carla");
        btree.add("Paul");
        btree.add("Kristi");
        btree.add("Xavier");
        System.out.println(btree);
    }
}
