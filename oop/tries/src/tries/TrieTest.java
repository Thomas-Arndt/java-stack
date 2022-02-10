package tries;
public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        System.out.println(trie.isWordValid("card"));
        System.out.println(trie.isWordValid("carpet"));
        System.out.println(trie.isWordValid("trie"));
        System.out.println(trie.isWordValid("tried"));
        System.out.println(trie.isPrefixValid("chi"));
        System.out.println(trie.isPrefixValid("tri"));
        System.out.println(trie.isPrefixValid("tre"));
        System.out.println(trie.isPrefixValid("che"));
        trie.printAllKeys(trie.root);
    }
}
