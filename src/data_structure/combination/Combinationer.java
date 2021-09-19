package data_structure.combination;

import java.util.*;

public class Combinationer {
    public List<List<String>> permutation(String[] strs, int r) {
        int n = strs.length;
        if (r > n || r <= 0) r = n;
        List<List<String>> res = new ArrayList<>();
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        List<String> tmpList = new ArrayList<>();
        for (int i = 0; i < r; i++) tmpList.add(strs[ids[i]]);
        res.add(tmpList);
        int[] cycles = new int[r];
        for (int i = 0; i < r; i++) cycles[i] = n - i;
        while (true) {
            int j = r - 1;
            for (; j >= 0; j--) {
                cycles[j]--;
                if (cycles[j] == 0) {
                    int tmp = ids[j];
                    for (int p = j; p < n - 1; p++) ids[p] = ids[p + 1];
                    ids[n - 1] = tmp;
                    cycles[j] = n - j;
                } else {
                    int t = cycles[j];
                    int tmp = ids[j];
                    ids[j] = ids[n - t];
                    ids[n - t] = tmp;
                    tmpList = new ArrayList<>();
                    for (int i = 0; i < r; i++) tmpList.add(strs[ids[i]]);
                    res.add(tmpList);
                    break;
                }
            }
            if (j == -1) break;
        }
        return res;
    }
}
