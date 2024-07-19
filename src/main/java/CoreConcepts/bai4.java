package CoreConcepts;

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

    // Find the greatest common divisor using Euclid
    public static int findGreatestCommonDivisor(int a, int b) {
        if (b == 0) return a;
        return findGreatestCommonDivisor(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input a, b
        System.out.println("Nhap so a: ");
        int a = sc.nextInt();
        System.out.println("Nhap so b (b >= " + a + "): ");
        int b;
        do {
            b = sc.nextInt();
            if (b < a) {
                System.out.println("Xin nhap lai so b >= " + a + ":");
            }
        } while (b < a);

        if (a < 2) {
            a = 2;
        }

        // print result
        System.out.println("Cac cap so nguyen to cung nhau trong doan [" + a + ", " + b + "] la :");

        for (int i=a; i<b; i++) {
            for (int j=i+1; j<=b; j++) {
                if (isPrimeNumber(i) && isPrimeNumber(j) && (findGreatestCommonDivisor(i, j) == 1)) {
                    System.out.println(i + " " + j);
                }
            }
        }

    }
}
