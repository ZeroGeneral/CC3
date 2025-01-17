/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergesort;

/**
 *
 * @author clyde
 */
import java.util.Arrays;

public class MergeSort {
    static int counter = 0; // Counter variable

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array and counter value
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count: " + counter);
    }

    static void mergeSort(int[] arr, int left, int right) {
        counter++; // Increment counter for method call
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            counter++; // Increment counter for middle point calculation

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        counter += 2; // Increment counter for size calculation

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        counter += 2; // Increment counter for array creation

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
            counter++;
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
            counter++;
        }

        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        counter += 3; // Increment counter for initial indices
        while (i < n1 && j < n2) {
            counter++; // Increment counter for loop condition
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            counter += 2; // Increment counter for assignments
        }

        // Copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            counter += 2; // Increment counter for assignments
        }

        // Copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            counter += 2; // Increment counter for assignments
        }
    }
}
