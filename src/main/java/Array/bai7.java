package Array;

import java.util.Scanner;

public class bai7 {
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

        // Input array
        System.out.print("Nhap mang a: ");
        // Create array of n elements
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0;
        int head = -1;
        int i = 0;
        while (i < n) {
            int count = 1;
            int tmp = i;
            while ((a[tmp]<=a[tmp+1]) && (tmp<(n-1))) {
                count += 1;
                tmp += 1;
            }
            if (count > max) {
                max = count;
                head = i;
                i = tmp;
            } else {
                i += 1;
            }
        }

        if (max > 1) {
            System.out.println("Duong chay dai nhat o vi tri " + head + " voi do dai la " + max);
        } else {
            System.out.println("Khong co duong chay dai nhat");
        }
    }

}
