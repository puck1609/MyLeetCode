package data_structure.base;

public class BinaryIndexedTree {
    private int[] diff;
    private int[] Mdiff;
    private int len;
    public BinaryIndexedTree(int[] in) {
        len = in.length;
        diff = new int[len + 1];
        Mdiff = new int[len + 1];
    }
    public void Update(int x, int add) {
        if (x > len || x < 1) return;
        int y = x;
        while (x <= len) {
            diff[x] += add;
            Mdiff[x] += (y - 1) * add;
            x += lowbit(x);
        }
    }
    public int Query(int x) {
        if (x > len || x < 1) return 0;
        int res = 0;
        int y = x;
        while (x > 0) {
            res += diff[x] * y - Mdiff[x];
            x -= lowbit(x);
        }
        return res;
    }
    private int lowbit(int x) {
        return x & (-x);
    }
    public void RangeUpdate(int l, int r, int add) {
        Update(l, add);
        Update(r + 1, -add);
    }
    public int RangeQuery(int l, int r) {
        return Query(r) - Query(l - 1);
    }
    public void GetArr(int[] in) {
        if (in.length != len) return;
        for (int i = 0; i < in.length; i++) {
            in[i] = Query(i + 1) - Query(i);
        }
    }
}