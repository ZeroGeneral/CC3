/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblesort;

/**
 *
 * @author clyde
 */
import java.util.Arrays;

public class BubbleSort {
    static int counter = 0;  // Counter for operations

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                counter++;  // Comparison operation
                if (arr[j] > arr[j + 1]) {
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    counter++;  // Swap operation count
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1};  // Dataset
        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Bubble Sort Counter: " + counter);
    }
}
