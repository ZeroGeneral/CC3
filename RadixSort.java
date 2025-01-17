/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package radixtrials;

/**
 *
 * @author clyde
 */

import java.util.Arrays;

public class RadixTrials {

    private static int counter = 0; // Global counter variable

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        int n = arr.length;

        // Find the maximum number to know the number of digits
        int max = getMax(arr, n);
        counter++; // For max finding

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            counter++; // For each loop iteration
            countingSort(arr, n, exp);
        }

        // Print sorted array and counter value
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count (TFC): " + counter);
    }

    static int getMax(int[] arr, int n) {
        int max = arr[0];
        counter++; // For initialization
        for (int i = 1; i < n; i++) {
            counter++; // Loop comparison
            if (arr[i] > max) {
                max = arr[i];
                counter++; // For assignment
            }
        }
        counter++; // Last loop check
        return max;
    }

    static void countingSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // Output array
        int[] count = new int[10];
        counter += 2; // For array initializations

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
            counter += 2; // For array access and increment
        }
        counter++; // Last loop check

        // Change count[i] so that count[i] contains actual position of this digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            counter++; // For addition
        }
        counter++; // Last loop check

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            counter += 3; // For array access, decrement, and assignment
        }
        counter++; // Last loop check

        // Copy the output array to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
            counter++; // For assignment
        }
        counter++; // Last loop check
    }
}

