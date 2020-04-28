/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Homework 10 - PopulationsDriver class
 */

public class PopulationsDriver {

    private static final String FILE_NAME = "population.csv";
    private Hashtable<String, Integer> pops;

    public PopulationsDriver() {
        pops = new Hashtable<>();
        loadData();
    }

    // TODO: finish the implementation of the method
    // this method should read all of the population data from "populations.csv into the hashtable "pops"
    public void loadData() {

    }

    // TODO: return the state population by querying the hashtable "pops"
    public int getPopulation(String state) {
        return 0;
    }

    public static void main(String[] args) {
        PopulationsDriver pd = new PopulationsDriver();
        System.out.println("Population of CO = " + pd.getPopulation("CO"));
    }
}
