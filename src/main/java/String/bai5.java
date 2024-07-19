package String;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ho ten: ");
        String s = sc.nextLine();
        String[] words = s.split("\\s+");
        String[] newOrder = new String[words.length];

        newOrder[0] = words[words.length-1];
        for (int i=0; i<words.length-1; i++) {
            newOrder[i+1] = words[i];
        }

        String result = String.join(" ", newOrder);
        System.out.println("Ho ten sau khi chuyen doi la: " + result);
    }
}
