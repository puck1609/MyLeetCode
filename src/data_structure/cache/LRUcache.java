package data_structure.cache;

import java.util.*;
import data_structure.base.*;

public class LRUcache {
    DeListNode hair, end;
    Map<Integer, DeListNode> map;
    private int capcity;
    private int size;
    LRUcache (int _capcity) {
        hair = new DeListNode(0);
        end = new DeListNode(0);
        hair.next = end;
        map = new HashMap<>();
        capcity = _capcity;
        size = 0;
    }
    public boolean Put(int key, int value) {
        if (capcity <= 0 || size < 0) return false;
        if (!map.containsKey(key)) {
            DeListNode node = new DeListNode(value);
            map.put(key, node);
            insertToHead(node);
            size++;
            if (size > capcity) {
                int keyToRemove = end.pre.val;
                map.remove(keyToRemove);
                removeTail();
                size--;
            }
            return true;
        }
        DeListNode node = map.get(key);
        node.val = value;
        insertToHead(node);
        return true;
    }
    public int Get(int key) {
        if (capcity <= 0 || size < 0) return -1;
        if (!map.containsKey(key)) {
            return -1;
        }
        DeListNode node = map.get(key);
        insertToHead(node);
        return node.val;
    }
    private void insertToHead(DeListNode node) {
        if (node.pre != null) node.pre.next = node.next;
        if (node.next != null) node.next.pre = node.pre;
        node.pre = hair;
        node.next = hair.next;
        if (hair.next != null) hair.next.pre = node;
        hair.next = node;
    }
    private void removeTail() {
        if (end.pre == hair) return;
        DeListNode toRemove = end.pre;
        toRemove.pre.next = end;
        end.pre = toRemove.pre;
        toRemove.pre = null;
        toRemove.next = null;
    }
}
