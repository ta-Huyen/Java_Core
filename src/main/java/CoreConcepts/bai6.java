package CoreConcepts;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tu nhien n (n >= 2): ");

        // input n
        int n;
        do {
            n = sc.nextInt();
            if (n < 2) {
                System.out.println("Xin nhap lai so tu nhien n >= 2:");
            }
        } while (n < 2);

        System.out.print(n + " = ");
        for(int i=2; i<=Math.sqrt(n); i++){
            //if n divive by i, i is prime factor
            while (n%i == 0){
                System.out.print(i);
                n =n/ i;
                if (n > 1) {
                    System.out.print("x");
                }
            }
        }
        if(n > 1){
            System.out.print(n);
        }
    }
}
