package trie;

/**
 * @author kinden
 */
public class Client {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("abcde");
        trie.insert("bcd");

        System.out.println(trie.search("aaaa"));
        System.out.println(trie.search("abc"));
    }
}
