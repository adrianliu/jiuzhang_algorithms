package jiuzhang.advanced.trie.imp1;

/**
 * Created by xiaopengliu on 5/04/16.
 */
public class Trie {

    public static void main(String[] args) {

        TrieContainer start = new TrieContainer();

        storeWords(start, "hello");
        storeWords(start, "hallo");
        storeWords(start, "hell");
        storeWords(start, "teg");
        storeWords(start, "tag");

        printWordStrings(start, "");
        System.out.println("\n" + isWordPresent(start, "teg"));


    }

    private static void storeWords(TrieContainer start, String word) {
        for(int j = 0;j < word.length();j++) {
            char character = word.charAt(j);
            if(start.series[character-97] != null) {
                if(word.length() - 1 == j) {
                    start.series[character-97].isEnd = true;
                }
                start = start.series[character-97];
            } else {
                TrieContainer trie = new TrieContainer();
                trie.isEnd = (word.length() - 1 == j ? true: false);
                start.series[character-97] = trie;
                start = start.series[character-97];
            }
        }
    }

    private static boolean isWordPresent(TrieContainer start, String word) {
        boolean isFound = true;
        for(int i = 0;i < word.length();i++) {
            char character = word.charAt(i);
            if(start.series[character-97] != null) {
                if(word.length() - 1 != i) {
                    start = start.series[character-97];
                } else {
                    if(!start.series[character-97].isEnd) {
                        isFound = false;
                    }
                }
            } else {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    private static void printWordStrings(TrieContainer start, String toPrint) {
        if(start == null) {
            return;
        }
        if(start.isEnd) {
            System.out.println(toPrint);
        }
        for(int i = 0;i < start.series.length;i++) {
            TrieContainer t = start.series[i];
            if(t != null) {
                printWordStrings(t, toPrint + (char)(97+i));
            }
        }
    }



}























