package data_structure.parser;

import data_structure.base.ListNode;
import java.util.*;

public class ListNodeSerializer {
    public String serialize(ListNode head) {
        StringBuffer buf = new StringBuffer();
        ListNode p = head;
        while (p != null) {
            buf.append(p.val).append(',');
            p = p.next;
        }
        buf.deleteCharAt(buf.length() - 1);
        return "[" + buf.toString() + "]";
    }
    public ListNode deserialize(String data) {
        String[] vals = data.substring(1, data.length() - 1).split(",");
        if (vals.length == 0) return null;
        ListNode head = new ListNode(Integer.parseInt(vals[0]));
        ListNode pre = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(vals[i]));
            pre.next = node;
            pre = node;
        }
        return head;
    }
}
