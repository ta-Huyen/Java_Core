package String;

import java.util.Scanner;

public class bai2 {
    // Convert string
    public static String convert(String s) {
        StringBuilder result = new StringBuilder();
        boolean toUpperCase = true;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                if (toUpperCase) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                toUpperCase = !toUpperCase;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap xau ky tu: ");
        String s = sc.nextLine();
        String result = convert(s);
        System.out.println("Chuoi sau khi chuyen doi la: " + result);
    }
}