package Array;

import java.util.Scanner;

public class bai12 {
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

        int[][] rotate = new int[n][n];
        for (int j=n-1; j>=0; j--){
            for(int i=0; i<n; i++){
                rotate[n-j-1][i] = a[i][j];
            }
        }

        System.out.println("Ma tran sau khi xoay 90 do nguoc kim dong ho la:");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
    }
}
