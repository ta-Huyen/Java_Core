package CoreConcepts;

import java.util.Scanner;

public class bai5 {
    // Calculate sum of digits
    public static int sum(int n) {
        // sum calculate the sum of all digits from n
        int sum = 0;

        n = Math.abs(n);
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input n
        System.out.print("Nhap vao n : ");
        int n = sc.nextInt();

        // print result
        System.out.print("Tong cac chu so cua " + n + " la: " + sum(n));

    }
}
