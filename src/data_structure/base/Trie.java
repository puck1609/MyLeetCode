package data_structure.base;

import java.util.*;

public class Trie {
    boolean isEnd;
    Map<Character, Trie> edges;
    Trie() {
        edges = new HashMap<>();
        isEnd = false;
    }
    public void insert(String str) {
        Trie trie = this;
        for (int i = 0; i < str.length(); i++) {
            trie.edges.putIfAbsent(str.charAt(i), new Trie());
            trie = trie.edges.get(str.charAt(i));
        }
        trie.isEnd = true;
    }
    public boolean select(String str) {
        Trie trie = this;
        for (int i = 0; i < str.length(); i++) {
            if (!trie.edges.containsKey(str.charAt(i))) {
                return false;
            }
            trie = trie.edges.get(str.charAt(i));
        }
        return trie.isEnd;
    }
}
