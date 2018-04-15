import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    // trie node
    static class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            word = null;
            isEndOfWord = false;
        }

        public String toString() {
            return String.format("%s", word);
        }
    }

    static void insert(String key) {
        TrieNode pCrawl = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'A';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.word = key;
        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode pCrawl = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'A';

            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public static void isChecker(String keys) {
        String output[] = { "Not present in trie", "Present in trie" };
        if (search(keys) == true)
            System.out.println(keys + " --- " + output[1]);
        else
            System.out.println(keys + " --- " + output[0]);
    }

    static void traverse(TrieNode root) {
        if (root != null) {
            for (TrieNode node : root.children) {
                if (node != null) {
                    if (node.word != null) {
                        System.out.println(node + " Child of: " + root);
                    }
                    traverse(node);
                }
            }
        }
        return;
    }

    // Driver
    public static void main(String args[]) throws FileNotFoundException {

        final String data = args[0]; // Gets the data file
        // Stores the data into Scanner
        Scanner sdtIn = new Scanner(new File(data));
        // Input keys (use only 'a' through 'z' and lower case)
        ArrayList<String> keys = new ArrayList<String>();

        root = new TrieNode();

        while (sdtIn.hasNextLine()) {
            insert(sdtIn.nextLine().toUpperCase());
        }

        /*for (int i = 0; i < 10; i++) {
            keys.add(sdtIn.nextLine().toUpperCase());
            insert(keys.get(i));
            // insert(sdtIn.nextLine().toUpperCase());
        }*/
        // traverse(root);

        for (int i = 0; i < keys.size(); i++) {
            isChecker(keys.get(i));
        }

        sdtIn.close();
    }
}