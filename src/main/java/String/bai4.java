package String;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap xau ky tu: ");
        String s = sc.nextLine();
        String[] words = s.split("\\s+");

        String result = "";

        for (String i : words) {
            if (i.length() > result.length()) {
                result = i;
            }
        }

        System.out.println("Tu dai nhat la " + result + " xuat hien o vi tri thu " + (s.indexOf(result) + 1));
    }
}
