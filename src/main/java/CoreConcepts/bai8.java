package CoreConcepts;

public class bai8 {
    // Create Palindromic numbers from 3 numbers
    public static int createPalindromicNumber(int a, int b, int c) {
        return a*100000 + b*10000 + c*1000 + c*100 + b*10 + a;
    }

    // Branch a
    public static void findPalindromicNumbers() {
        for (int a=1; a<=9; a++){
            for (int b=0; b<=9; b++){
                for (int c=0; c<=9; c++) {
                    System.out.println(createPalindromicNumber(a, b, c));
                }
            }
        }
    }

    // Branch b
    public static void findPalindromicNumbersWithSumOfDigitsDivisibleBy10() {
        for (int a=1; a<=9; a++){
            for (int b=0; b<=9; b++){
                for (int c=0; c<=9; c++) {
                    int sum = a+b+c;
                    if (sum%5 == 0) {
                        System.out.println(createPalindromicNumber(a, b, c));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Branch a
        System.out.println("Cac so thuan nghich co 6 chu so la:");
        findPalindromicNumbers();

//        // Branch b
//        System.out.println("Cac so thuan nghich co 6 chu so ma tong cac chu so chia het cho 10 la:");
//        findPalindromicNumbersWithSumOfDigitsDivisibleBy10();

    }
}
