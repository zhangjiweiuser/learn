package learn.chapter2022.chapter10.chapter1031;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-10-31 9:49
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {5, 4, 1, 6,2,8, 6, 7, 0, 88, 74, 571};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int m = partition(arr, left, right);
        quickSort(arr, left, m - 1);
        quickSort(arr, m + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, ++j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
