package Array;

import java.util.Scanner;

public class bai1 {
    // Check if array is palindromic
    public static boolean isPalindrome(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n/2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                return false;
            }
        }
        return true;
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
        int[] arr = new int[n];

        // Input array
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        if (isPalindrome(arr)) {
            System.out.println("la doi xung");
        } else {
            System.out.println("khong doi xung");
        }
    }
}