/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quicksort1;

/**
 *
 * @author clyde
 */
import java.util.Arrays;

public class QuickSort1 {
    static int counter = 0; // Counter variable

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array and counter value
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Instruction Count: " + counter);
    }

    static void quickSort(int[] arr, int low, int high) {
        counter++; // Increment counter for method call
        if (low < high) {
            // Partition the array
            int pi = partition(arr, low, high);
            counter++; // Increment counter for partition operation

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        counter++; // Increment counter for pivot assignment
        int i = (low - 1); // Index of smaller element
        counter++; // Increment counter for index initialization

        for (int j = low; j < high; j++) {
            counter++; // Increment counter for loop iteration
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                counter += 3; // Increment counter for swap
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        counter += 3; // Increment counter for final swap

        return i + 1;
    }
}

