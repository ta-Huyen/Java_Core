package String;

import java.util.Arrays;
import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap cau: ");
        String s = sc.nextLine();
        String[] words = s.split("\\s+");

        Arrays.sort(words);

        System.out.println("Cac tu theo thu tu Alphabet la:");
        for (String i : words) {
            System.out.println(i);
        }

    }
}
