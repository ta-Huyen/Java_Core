package Array;

import java.util.Scanner;

public class bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input m, n, k
        int n;
        System.out.println("Nhap vao n (n>0): ");
        n = sc.nextInt();

        // Matrix a, b
        int[][] a = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        int sumSub = 0;

        for (int i=0; i<n; i++){
            sum += a[i][i];
            sumSub += a[i][n-i-1];
        }

        System.out.println("Tong cac phan tu tren duong cheo chinh la: " + sum);
        System.out.println("Tong cac phan tu tren duong cheo phu la: " + sumSub);
    }
}
