/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Song class
 * Name(s):
 */

public class Song implements Comparable<Song> {

    private String title;
    private String artist;
    private int    rank;
    private int    key;

    public static final int MIN_RANK  = 1;
    public static final int MAX_RANK  = 5;
    public static final int TITLE_KEY  = 1;
    public static final int ARTIST_KEY = 2;
    public static final int RANK_KEY   = 3;

    // TODO: implement the constructor
    public Song(String title, String artist, int rank) {

    }

    // TODO: implement all getter methods


    // TODO: implement the setter method


    // TODO: implement the compareTo override based on the current key value (note that rank should be from higher to lower rank)
    @Override
    public int compareTo(Song other) {
        return 0;
    }

    // TODO: implement the toString override
    @Override
    public String toString() {
        return "";
    }
}
