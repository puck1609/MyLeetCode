public class Heap {
    private int[] arr;
    private int len;
    static final int INVALID = Integer.MIN_VALUE;
    Heap(int[] in) {
        arr = in;
        len = arr.length;
        init();
    }
    private void init() {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(i);
        }
    }
    public void adjust(int i) {
        if (i >= len) return;
        int li = i * 2 + 1;
        int ri = i * 2 + 2;
        int l = li >= len ? INVALID : arr[li];
        int r = ri >= len ? INVALID : arr[ri];
        if (l == INVALID) return;
        if (r == INVALID) {
            if (arr[i] >= l) {
                return;
            }
            swap(arr, i, li);
            adjust(li);
            return;
        }
        int Max = arr[i];
        Max = Math.max(Max, Math.max(arr[li], arr[ri]));
        if (Max == arr[li]) {
            swap(arr, i, li);
            adjust(li);
            return;
        }
        if (Max == arr[ri]) {
            swap(arr, i, ri);
            adjust(ri);
            return;
        }
    }
    private void swap(int[] arr, int i, int j) {
        if (i >= len || j >= len) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public void subLen() {
        if (len > 0) len--;
    }
}
