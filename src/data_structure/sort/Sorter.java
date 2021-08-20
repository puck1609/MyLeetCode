package data_structure.sort;

import data_structure.base.Heap;
import java.util.Random;

public class Sorter {
    public enum SortStrategy {
        QUICKSORT, MERGESORT, HEAPSORT;
    }
    public Sorter() {

    }
    public void sort(int[] arr, SortStrategy strategy) {
        switch (strategy) {
            case QUICKSORT:{
                Quicksort(arr);
                break;
            }
            case MERGESORT:{
                Mergesort(arr);
                break;
            }
            case HEAPSORT:{
                Heapsort(arr);
                break;
            }
        }
    }
    private void Quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }
    private void Mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }
    private void Heapsort(int[] arr) {
        Heap heap = new Heap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heap.subLen();
            heap.adjust(0);
        }
    }
    private void quicksort(int[] arr, int l, int r) {
        if (l >= r) return;
        Random random = new Random();
        int pivot = random.nextInt(r - l + 1) + l;
        swap(arr, pivot, l);
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= arr[l]) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j - 1, l);
        quicksort(arr, l, j - 2);
        quicksort(arr, j, r);
    }
    private void swap(int[] arr, int i, int j) {
        int len = arr.length;
        if (i >= len || j >= len) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private void mergesort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);
        merge(arr, l, r, mid + 1);
    }
    private void merge(int[] arr, int l, int r, int m) {
        int len = r - l + 1;
        int[] tmp = new int[len];
        System.arraycopy(arr, l, tmp, 0, len);
        int p1 = 0, p2 = m - l, p = l;
        while (p1 < m - l && p2 < len) {
            if (tmp[p1] <= tmp[p2]) {
                arr[p++] = tmp[p1++];
            } else {
                arr[p++] = tmp[p2++];
            }
        }
        while (p1 < m - l) {
            arr[p++] = tmp[p1++];
        }
        while (p2 < len) {
            arr[p++] = tmp[p2++];
        }
    }
}
