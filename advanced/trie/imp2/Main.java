package jiuzhang.advanced.trie.imp2;

/**
 * Created by xiaopengliu on 6/04/16.
 */
public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("this");
        trie.insert("is");
        trie.insert("adrian");

        System.out.println(trie.startsWith("adria"));

    }
}
