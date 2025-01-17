/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package radixsort;

/**
 *
 * @author clyde
 */
import java.util.Arrays;

public class RadixSort{
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        int n = arr.length;
        int counter = 0; // Counter variable

        // Find the maximum number to know the number of digits
        int max = getMax(arr, n);
        counter++; // For max finding

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            counter++;
            countingSort(arr, n, exp, counter);
        }

        // Print sorted array and counter value
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count: " + counter);
    }

    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countingSort(int[] arr, int n, int exp, int counter) {
        int[] output = new int[n]; // Output array
        int[] count = new int[10];
        counter += 2; // For output and count array initialization

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
            counter++;
        }

        // Change count[i] so that count[i] contains actual position of this digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            counter++;
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            counter += 2;
        }

        // Copy the output array to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
            counter++;
        }
    }
}
