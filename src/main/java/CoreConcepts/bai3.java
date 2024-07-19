package CoreConcepts;

import java.util.Scanner;

public class bai3 {
    // Find the greatest common divisor using Euclid
    public static int findGreatestCommonDivisor(int a, int b) {
        if (b == 0) return a;
        return findGreatestCommonDivisor(b, a % b);
    }

    public static int inputNumber(Scanner sc, char tmp) {
        System.out.print("Nhap so tu nhien " + tmp + " (" + tmp + " > 0): ");

        // input n
        int n = 0;
        do {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Xin nhap lai so tu nhien " + tmp + " > 0:");
            }
        } while (n <= 0);

        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input a, b
        int a = inputNumber(sc, 'a');
        int b = inputNumber(sc, 'b');

        // find the greatest common divisor and the least common multiple
        int ucln = findGreatestCommonDivisor(a,b);
        int bcnn = (a*b) / ucln;

        // print result
        System.out.println("Uoc chung lon nhat cua " + a + " va " + b + " la : " + ucln);
        System.out.println("Boi chung nho nhat cua " + a + " va " + b + " la : " + bcnn);
    }
}