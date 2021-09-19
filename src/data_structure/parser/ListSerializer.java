package data_structure.parser;

import java.util.*;

public class ListSerializer {
    public String serializeInteger(List<Integer> l) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < l.size(); i++) {
            buf.append(l.get(i));
            if (i != l.size() - 1) buf.append(",");
        }
        return "[" + buf.toString() + "]";
    }
    public List<Integer> deserializeInteger(String str) {
        List<Integer> l = new ArrayList<>();
        str = str.substring(1, str.length() - 1);
        if (str.equals("")) return l;
        String[] strs = str.split(",");
        for (int i = 0; i < strs.length; i++) l.add(Integer.valueOf(strs[i]));
        return l;
    }
    public String serializeString(List<String> l) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < l.size(); i++) {
            buf.append("\"").append(l.get(i)).append("\"");
            if (i != l.size() - 1) buf.append(",");
        }
        return "[" + buf.toString() + "]";
    }
    public List<String> deserializeString(String str) {
        List<String> l = new ArrayList<>();
        str = str.substring(1, str.length() - 1);
        if (str.equals("")) return l;
        String[] strs = str.split(",");
        for (int i = 0; i < strs.length; i++) l.add(strs[i]);
        return l;
    }
}
