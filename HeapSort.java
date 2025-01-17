/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heapsort;

/**
 *
 * @author clyde
 */
import java.util.Arrays;

public class HeapSort {
    static int counter = 0;  // Counter for operations

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            counter++;  // Swap operation count
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        counter++;  // Comparison operation

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        counter++;  // Comparison operation
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            counter++;  // Swap operation count
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};  // Dataset
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Heap Sort Counter: " + counter);
    }
}

