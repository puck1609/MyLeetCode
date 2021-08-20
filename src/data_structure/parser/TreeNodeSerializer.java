package data_structure.parser;

import data_structure.base.TreeNode;

import java.util.*;

public class TreeNodeSerializer {

    public String serialize(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        int realSize = root == null ? 0 : 1;
        while (realSize > 0) {
            int tmpRealSize = 0;
            while (realSize > 0) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append("null,");
                    continue;
                }
                realSize--;
                sb.append(cur.val).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
                if (cur.left != null) tmpRealSize++;
                if (cur.right != null) tmpRealSize++;
            }
            realSize = tmpRealSize;
        }
        if (sb.length() == 0) return "[]";
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }

    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) return null;
        String[] strs = data.split(",");
        List<TreeNode> l = new ArrayList<>();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            TreeNode cur = null;
            if (!strs[i].equals("null")) {
                cur = new TreeNode(Integer.parseInt(strs[i]));
            }
            l.add(cur);
        }
        for (int i = 0, j = 0; j < n; i++) {
            if (l.get(i) == null) continue;
            if (++j < n) l.get(i).left = l.get(j);
            if (++j < n) l.get(i).right = l.get(j);
        }
        return l.get(0);
    }
}
