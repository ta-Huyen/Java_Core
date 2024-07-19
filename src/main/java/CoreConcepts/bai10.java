package CoreConcepts;

public class bai10 {
    // Create palindromic number with 7 digits
    public static int createPalindromicNumber7(int a, int b, int c, int d, int e, int f, int g) {
        int head = a*1000 + b*100 + c*10 + d;
        int tail = e*100 + f*10 + g;
        return head*1000 + tail;
    }

    // Check prime number
    public static boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Cac so nguyen to co 7 chu so thoa man la: ");

        // Prime numbers from 1->10
        int[] arr = {2, 3, 5, 7};
        int[] arr2 = {3, 7};

        for (int a : arr2) {
            for (int b : arr) {
                for (int c : arr) {
                    for (int d : arr) {
                        for (int e : arr) {
                            for (int f : arr) {
                                for (int g : arr2) {
                                    int n = createPalindromicNumber7(a, b, c, d, e, f, g);
                                    if (isPrimeNumber(n)) {
                                        int reverseN = createPalindromicNumber7(g, f, e, d, c, b, a);
                                        if (isPrimeNumber(reverseN)) {
                                            System.out.println(n);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
