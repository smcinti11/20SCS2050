/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Activity 16 - CipherMain class
 */

import java.io.*;
import java.util.*;

public class CipherMainSol {

    public static final String ENCRYPTED_TEXT         = "encrypted.txt";
    public static final String COMMON_WORDS           = "common.txt";
    public static final String LETTERS                = "abcdefghijklmnopqrstuvwxyz";
    public static final int    KEY_SIZE               = 6;
    public static final double COMMON_WORDS_THRESHOLD = .3;

    public static void main(String[] args) throws FileNotFoundException {

        // TODO: read the encrypted text from ENCRYPTED_TEXT file
        Scanner sc = new Scanner(new FileInputStream(ENCRYPTED_TEXT));
        String encrypted = sc.nextLine();
        sc.close();

        // TODO: create a list of common words in English with words from COMMON_WORDS file
        LinkedList<String> commonWords = new LinkedList<>();
        sc = new Scanner(new FileInputStream(COMMON_WORDS));
        while (sc.hasNextLine())
            commonWords.add(sc.nextLine());
        sc.close();

        // TODO: initialize a stack with the letters of the alphabet
        char letters[] = LETTERS.toCharArray();
        DynamicStack<String> stack = new DynamicStack<>();
        for (char letter : letters)
            stack.push("" + letter);

        // TODO: implement the exhaustive search algorithm main loop, maintaining a counter of the number of keys tested
        int total = 0;
        while (!stack.isEmpty()) {
            String key = stack.pop();
            if (key.length() == KEY_SIZE) {
                total++;
                String decoded = Cipher.decode(encrypted, key);
                // message has more than a minimum percent of common words
                String words[] = decoded.split(" ");
                int count = 0;
                for (String word : words)
                    if (word.length() > 2 && commonWords.contains(word))
                        count++;
                double percentCommonWords = (double) count / words.length;
                if (percentCommonWords >= COMMON_WORDS_THRESHOLD) {
                    System.out.println("key \"" + key + "\" decoded message \"" + decoded + "\" after trying " + total + " different keys!");
                    break;
                }
            }
            else if (key.length() < KEY_SIZE)
                for (char letter : letters)
                    stack.push(key + letter);
        }
    }
}
