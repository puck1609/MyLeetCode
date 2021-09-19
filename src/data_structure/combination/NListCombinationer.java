package data_structure.combination;

import java.util.*;

// 使用迭代解决N个字符串列表的组合问题，节省递归栈的空间消耗
public class NListCombinationer {
    List<List<String>> list;
    int len;
    public NListCombinationer(List<List<String>> in) {
        list = in;
        len = in.size();
    }
    public List<List<String>> CalCombination() {
        List<List<String>> res = new ArrayList<>();
        int[] indexes = new int[len + 1];
        int p = len;
        while (indexes[0] < 1) {
            List<String> tmp = new ArrayList<>();
            for (int i = 1; i <= len; i++) {
                tmp.add(list.get(i - 1).get(indexes[i]));
            }
            res.add(tmp);
            indexes[p]++;
            while (p >= 1 && indexes[p] >= list.get(p - 1).size()) {
                indexes[p--] = 0;
                indexes[p]++;
            }
            p = len;
        }
        return res;
    }
}
