package radixtrials;

import java.util.Arrays;

public class RadixTrials {
    private static int counter = 0; // Global counter for TFC

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count (TFC): " + counter);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            counter++; // Condition check
            int pi = partition(arr, low, high);
            counter++; // Partition call
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        counter++; // Final condition check
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        counter++; // Pivot assignment
        int i = low - 1;
        counter++; // i initialization

        for (int j = low; j < high; j++) {
            counter++; // Loop condition
            if (arr[j] < pivot) {
                counter++; // Condition check
                i++;
                counter++; // Increment i
                swap(arr, i, j);
                counter++; // Swap call
            }
        }
        counter++; // Final loop condition check

        swap(arr, i + 1, high);
        counter++; // Final swap call
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        counter += 3; // For the swap operations
    }
}
