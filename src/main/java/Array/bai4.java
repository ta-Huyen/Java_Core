package Array;

import java.util.Scanner;

public class bai4 {
    // Check prime number
    public static boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap vao n (n>0) : ");
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

        // input x
        System.out.print("Nhap vao x : ");
        int x = sc.nextInt();

        int position = -1;
        for (int i=0; i<n; i++) {
            if (isPrimeNumber(arr[i])) {
                if ((position == -1) || (Math.abs(arr[position] - x) > Math.abs(arr[i] - x))) {
                    position = i;
                }
            }
        }

        if (position == -1) {
            System.out.println("Khong co so nguyen to nao thoa man");
        } else {
            System.out.println("Phan tu thu " + (position + 1) + " co gia tri gan " + x + " nhat");
        }
    }
}
