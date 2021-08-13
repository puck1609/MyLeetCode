public class BinaryIndexedTree {
    int[] arr;
    int len;
    BinaryIndexedTree(int[] in) {
        len = in.length;
        arr = new int[len + 1];
    }
    void update(int x, int add) {
        if (x > len) return;
        while (x <= len) {
            arr[x] += add;
            x += lowbit(x);
        }
    }
    int query(int x) {
        if (x > len) return -1;
        int res = 0;
        while (x > 0) {
            res += arr[x];
            x -= lowbit(x);
        }
        return res;
    }
    int lowbit(int x) {
        return x & (-x);
    }
}
