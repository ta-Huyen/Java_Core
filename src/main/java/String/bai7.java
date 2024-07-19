package String;

import java.util.Scanner;

public class bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap xau s1: ");
        String s1 = sc.nextLine();
        System.out.println("Nhap xau s2: ");
        String s2 = sc.nextLine();

        while (s1.contains(s2)) {
            s1 = s1.replaceAll(s2, "");
        }

        System.out.println("Xau s1 sau khi loai bo s2 la: " + s1);
    }
}
