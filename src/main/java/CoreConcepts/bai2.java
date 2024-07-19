package CoreConcepts;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tu nhien n (n > 0): ");

        // input n
        int n;
        do {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Xin nhap lai so tu nhien n > 0:");
            }
        } while (n <= 0);

        // counting divisor
        int count = 0;

        System.out.printf("Cac uoc so cua " + n + " la:");

        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                System.out.print(" " + i);
                count += 1;
            }
        }

        // print the number of divisors
        System.out.println();
        System.out.println("So luong cac uoc so: " + count);

    }
}
