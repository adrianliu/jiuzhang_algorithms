package jiuzhang.advanced.trie.imp2;

import java.util.HashMap;

/**
 * Created by xiaopengliu on 6/04/16.
 */
public class Trie {

    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode() {

        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //Inserts a word into the Trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode t;
            if (children.containsKey(ch)) {
                t = children.get(ch);
            } else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }
            children = t.children;

            //set leaf node
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }


    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode t = searchNode(prefix);
        return t != null;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t == null) {
            return false;
        }
        if(t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    public TrieNode searchNode(String str) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (children.containsKey(ch)) {
                t = children.get(ch);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}





















