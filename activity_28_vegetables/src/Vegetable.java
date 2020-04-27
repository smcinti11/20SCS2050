/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 28 - Vegetable class
 */

public class Vegetable {

    private String name;
    private double price;

    public Vegetable(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": $" + String.format("%.2f", price);
    }
}
