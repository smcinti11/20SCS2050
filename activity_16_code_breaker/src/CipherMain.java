/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 16 - CipherMain class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CipherMain {

    public static final String ENCRYPTED_TEXT         = "encrypted.txt";
    public static final String COMMON_WORDS           = "common.txt";
    public static final String LETTERS                = "abcdefghijklmnopqrstuvwxyz";
    public static final int    KEY_SIZE               = 6;
    public static final double COMMON_WORDS_THRESHOLD = .3;

    public static void main(String[] args) throws FileNotFoundException {

        // TODOd: read the encrypted text from ENCRYPTED_TEXT file
        Scanner in = new Scanner(new FileInputStream(ENCRYPTED_TEXT));
        String encoded = in.nextLine();
        in.close();

        // TODOd: create a list of common words in English with words from COMMON_WORDS file
        LinkedList<String> commonWords = new LinkedList<>();
        in = new Scanner(new FileInputStream(COMMON_WORDS));
        while (in.hasNextLine()) {
            String word = in.nextLine();
            commonWords.add(word);
        }
        in.close();


        // TODOd: initialize a stack with the letters of the alphabet
        DynamicStack<String> stack = new DynamicStack<>();
        for (int i = 0; i < LETTERS.length(); i++)
            stack.push(LETTERS.charAt(i) + "");

        // TODOd: implement the exhaustive search algorithm main loop, maintaining a counter of the number of keys tested
        while (!stack.isEmpty()) {

            String key = stack.pop();
            if (key.length() == KEY_SIZE) {
                String decoded = Cipher.decode(encoded, key);
                String words[] = decoded.split(" ");
                int total = 0;
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if (commonWords.contains(word))
                        total++;
                }
                double percentCommonWords = (double) total / words.length;
                if (percentCommonWords >= COMMON_WORDS_THRESHOLD)
                    System.out.println(key + " - " + decoded );
            }
            else
                for (int i = 0; i < LETTERS.length(); i++)
                    stack.push(key + LETTERS.charAt(i));
        } // end while
    }
}
