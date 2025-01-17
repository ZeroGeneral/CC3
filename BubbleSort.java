package radixtrials;

import java.util.Arrays;

public class RadixTrials {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        int n = arr.length;
        int counter = 0; // Counter for TFC

        // Bubble Sort Algorithm
        for (int i = 0; i < n - 1; i++) {
            counter++; // Outer loop condition
            for (int j = 0; j < n - i - 1; j++) {
                counter++; // Inner loop condition
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    counter += 3; // Swap operations
                }
                counter++; // If condition check
            }
            counter++; // Final inner loop condition
        }
        counter++; // Final outer loop condition

        // Print sorted array and TFC
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count (TFC): " + counter);
    }
}
