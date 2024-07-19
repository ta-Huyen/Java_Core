package CoreConcepts;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input n
        System.out.print("Nhap vao n : ");
        int n = sc.nextInt();

        // sumA calculate the sum of odd/even numbers from 1->n
        int sumA = 0;
        // sumB calculate the sum of 1 + 1/2 + 1/3 +...+ 1/n
        float sumB = 0;

        if (n > 0) {
            if (n%2 == 0) {
                sumA = (n+2)*n/4;
                System.out.print("Tong cac so chan tu 1 den " + n + " la: ");
            } else {
                sumA = (n+1)*(n+1)/4;
                System.out.print("Tong cac so le tu 1 den " + n + " la: ");
            }
            for (int i=1; i<=n; i++) {
                sumB += (float) 1/i;
            }
        } else {
            System.out.print("Tong cac so den 0 la: ");
        }

        // print result
        System.out.println(sumA);
        System.out.printf("Tong cac phan so tu 1 den 1/" + n + " la: " + sumB);

    }
}
