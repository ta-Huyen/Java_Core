package Array;

import java.util.Scanner;

public class bai3 {
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
        // Array to count arr[i]'s appearance
        int maxArr = 1000000;
        int[] count = new int[maxArr];
        for(int i=0; i<maxArr; i++) {
            count[i] = 0;
        }
        // Input array
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]] += 1;
        }

        for(int i=0; i<maxArr; i++) {
            if(count[i] > 0){
                System.out.println("Gia tri " + i + " xuat hien " + count[i] + " lan");
            }
        }

        int max = arr[0];
        for (int i=1; i<n; i++) {
            if (count[arr[i]] > count[max]) {
                max = arr[i];
            }
        }
        System.out.println("Gia tri " + max + " xuat hien nhieu lan nhat");
    }
}
