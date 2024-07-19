package String;

public class bai1 {
    // Check palidrome
    public static boolean isPalidrome(int number) {
        String str = Integer.toString(number);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Cac so thuan nghich co 6 chu so la:");
        for (int i=100000; i<=999999; i++) {
            if (isPalidrome(i)) {
                System.out.println(i);
            }
        }
    }

}
