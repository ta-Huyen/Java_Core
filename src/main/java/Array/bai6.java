package Array;

import java.util.Scanner;

public class bai6 {
    public static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }

    // Quick sort array by increase order
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pivot là chỉ mục của chốt, arr[pivot] vị trí của chốt
            int pivot = partition(arr, low, high);

            // Sắp xếp đệ quy các phần tử
            // trước phân vùng và sau phân vùng
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao n (n>0) : ");
        // input n
        int n;
        do {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Xin nhap lai so tu nhien n > 0:");
            }
        } while (n <= 0);

        // Create array of n elements
        int[] arr = new int[n+1];

        // Input array
        System.out.print("Nhap mang a: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // sort
        quickSort(arr, 0, n-1);

        System.out.print("Mang theo thu tu tang dan:");
        for(int i=0; i<n; i++) {
            System.out.print(" " + arr[i]);
        }

        System.out.println();
        System.out.println("Nhap gia tri x : ");
        // input n
        int x = sc.nextInt();

        System.out.print("Mang chen gia tri x : ");
        int position = n;
        for (int i=0; i<n; i++)
            if (x < arr[i]) {
                position = i;
                break;
            }
        // move all element from the inserted position to the right
        for (int i=n; i>position; i--){
            arr[i] = arr[i - 1];
        }
        // Insert x into position
        arr[position] = x;
        for(int i=0; i<=n; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
