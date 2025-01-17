package radixtrials;

import java.util.Arrays;

public class RadixTrials {
    private static int counter = 0; // Global counter for TFC

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        int n = arr.length;

        heapSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count (TFC): " + counter);
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            counter++; // Loop condition
            heapify(arr, n, i);
        }
        counter++; // Final loop condition check

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            counter++; // Loop condition
            swap(arr, 0, i);
            heapify(arr, i, 0);
            counter += 2; // Swap and heapify calls
        }
        counter++; // Final loop condition check
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        counter += 3; // Index calculations

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
            counter++; // Condition check and assignment
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
            counter++; // Condition check and assignment
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
            counter += 2; // Swap and recursive call
        }
        counter++; // Final condition check
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        counter += 3; // Swap operations
    }
}
