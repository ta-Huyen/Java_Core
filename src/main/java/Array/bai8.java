package Array;

import java.util.Scanner;

public class bai8 {

    public static void inputMatrix(int[][] arr,int m,int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void calculate(int m, int n, int k, int[][] a, int[][] b) {
        int[][] c = new int[m][k];
        for(int i=0; i<m; i++){
            for(int j=0; j<k; j++){
                c[i][j]=0;
                for(int q=0; q<n; q++){
                    c[i][j] += a[i][q]*b[q][j];
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<k; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input m, n, k
        int m, n, k;
        System.out.println("Nhap vao m (m>0) : ");
        m = sc.nextInt();
        System.out.println("Nhap vao n (n>0) : ");
        n = sc.nextInt();
        System.out.println("Nhap vao k (k>0) : ");
        k = sc.nextInt();

        // Matrix a, b
        int[][] a = new int[m][n];
        int[][] b = new int[n][k];
        System.out.println("Nhap ma tran a: ");
        inputMatrix(a, m, n);
        System.out.println("Nhap ma tran b: ");
        inputMatrix(b, n, k);

        System.out.println("Tich cua hai ma tran la: ");
        calculate(m, n, k, a, b);
    }
}
