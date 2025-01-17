package radixtrials;

import java.util.Arrays;

public class RadixTrials {
    private static int counter = 0; // Global counter for TFC

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count (TFC): " + counter);
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            counter++; // Condition check
            int m = l + (r - l) / 2;
            counter++; // Middle calculation
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
            counter++; // Merge call
        }
        counter++; // Final condition check
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        counter += 2; // Sizes of temporary arrays

        int[] L = new int[n1];
        int[] R = new int[n2];
        counter += 2; // Temporary arrays initialization

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
            counter++; // Array copy operation
        }
        counter++; // Final loop condition check

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
            counter++; // Array copy operation
        }
        counter++; // Final loop condition check

        int i = 0, j = 0, k = l;
        counter += 3; // Index initializations

        while (i < n1 && j < n2) {
            counter++; // Loop condition
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            counter += 4; // Assignments and increments
        }
        counter++; // Final loop condition check

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            counter += 3; // Assignments and increments
        }
        counter++; // Final loop condition check

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            counter += 3; // Assignments and increments
        }
        counter++; // Final loop condition check
    }
}
