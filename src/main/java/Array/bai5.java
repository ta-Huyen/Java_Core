package Array;

import java.util.Scanner;

public class bai5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int m;
        int p;

        // input n
        System.out.print("Nhap vao n (n>0) : ");
        do {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Xin nhap lai so tu nhien n > 0:");
            }
        } while (n <= 0);

        // Create array of n elements
        System.out.print("Nhap mang a: ");
        int[] a = new int[n];
        // Input array
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        // input m
        System.out.print("Nhap vao m (m>0) : ");
        do {
            m = sc.nextInt();
            if (m <= 0) {
                System.out.println("Xin nhap lai so tu nhien m > 0:");
            }
        } while (m <= 0);

        // Create array of m elements
        System.out.print("Nhap mang b: ");
        int[] b = new int[m];
        // Input array
        for(int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }

        // input n
        System.out.print("Nhap vao vi tri chen p (0<=p<n) : ");
        do {
            p = sc.nextInt();
            if ((p < 0) || (p >= n)) {
                System.out.println("Xin nhap lai so tu nhien p:");
            }
        } while ((p < 0) || (p >= n));

        // input n
        System.out.print("Mang sau khi chen :");
        for (int i=0; i<p; i++) {
            System.out.print(" " + a[i]);
        }
        for (int i : b) {
            System.out.print(" " + i);
        }
        for (int i=p; i<n; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
