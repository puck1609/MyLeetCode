package data_structure.base;

import java.util.*;

public class Trie {
    public Map<Character, Trie> next;
    public boolean isEnd;
    public Trie() {
        next = new HashMap<>();
        isEnd = false;
    }
    public void insert(String s) {
        Trie curPos = this;
        for (int i = 0; i <= s.length(); i++) {
            char c = s.charAt(i);
            curPos.next.putIfAbsent(c, new Trie());
            curPos = curPos.next.get(c);
        }
        curPos.isEnd = true;
    }
}
