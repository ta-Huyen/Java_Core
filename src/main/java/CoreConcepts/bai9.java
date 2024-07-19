package CoreConcepts;

public class bai9 {
    // Create palindromic number with 7 digits
    public static int createPalindromicNumber7(int a, int b, int c, int d) {
        int head = a*1000 + b*100 + c*10 + d;
        int tail = c*100 + b*10 + a;
        return head*1000 + tail;
    }

    // Create palindromic number with 8 digits
    public static int createPalindromicNumber8(int a, int b, int c, int d) {
        int head = a*1000 + b*100 + c*10 + d;
        int tail = d*1000 + c*100 + b*10 + a;
        return head*10000 + tail;
    }

    // Create palindromic number with 9 digits
    public static int createPalindromicNumber9(int a, int b, int c, int d, int e) {
        int head = a*10000 + b*1000 + c*100 + d*10 + e;
        int tail = d*1000 + c*100 + b*10 + a;
        return head*10000 + tail;
    }

    public static void main(String[] args) {
        int[] arr = {0, 6, 8};

        for (int a : arr) {
            for (int b : arr) {
                for (int c : arr) {
                    for (int d : arr) {
                        if (a != 0) {
                            int sum7digits = (a+b+c)*2 + d;
                            if (sum7digits%10 == 0) {
                                System.out.println(createPalindromicNumber7(a, b, c, d));
                            }

                            int sum8digits = a+b+c+d;
                            if (sum8digits%5 == 0) {
                                System.out.println(createPalindromicNumber8(a, b, c, d));
                            }

                            for (int e : arr) {
                                int sum9digits = (a+b+c+d)*2 + e;
                                if (sum9digits%10 == 0) {
                                    System.out.println(createPalindromicNumber9(a, b, c, d, e));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
