package hust.soict.globalict.lab01.Array.src;

import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter size of the array:\n");
        int n = keyboard.nextInt();
        int[] arr = new int[1000];
        int[] helper = new int[1000];
        System.out.println("Enter the array:\n");
        for (int i = 0; i < n; i++) {
            arr[i] = keyboard.nextInt();
        }
        mergeSort(arr, helper, 0, n-1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        System.out.println("Sorted array:\n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nSum = " + sum);
        System.out.println("Average = " + sum/n);


    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, helper, low, mid);
            mergeSort(arr, helper, mid + 1, high);
            merge(arr, helper, low, mid, high);
        }
    }

    private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (helper[i] <= helper[j]) {
                arr[k++] = helper[i++];
            } else {
                arr[k++] = helper[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = helper[i++];
        }
    }
}
