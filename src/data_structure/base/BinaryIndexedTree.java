package data_structure.base;

public class BinaryIndexedTree {
    private int[] origin;
    private int[] arr;
    private int len;
    public BinaryIndexedTree(int[] in) {
        len = in.length;
        arr = new int[len + 1];
        origin = new int[len];
        System.arraycopy(in, 0, origin, 0, len);
        for (int i = 0; i < len; i++) {
            Update(i + 1, origin[i]);
        }
    }
    public void Update(int x, int add) {
        if (x > len || x < 1) return;
        while (x <= len) {
            arr[x] += add;
            x += lowbit(x);
        }
    }
    public int Query(int x) {
        if (x > len || x < 1) return 0;
        int res = 0;
        while (x > 0) {
            res += arr[x];
            x -= lowbit(x);
        }
        return res;
    }
    public void Set(int x, int val) {
        if (x > len || x < 1) return;
        int add = val - origin[x - 1];
        origin[x - 1] = val;
        Update(x, add);
    }
    private int lowbit(int x) {
        return x & (-x);
    }
}
