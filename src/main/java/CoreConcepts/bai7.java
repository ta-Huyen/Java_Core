package CoreConcepts;

public class bai7 {
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
        System.out.println("Cac so nguyen to co 6 chu so chi bao gom cac chu so le la:");

        // Array of odd number from 1->10
        int[] arr = {1, 3, 5, 7, 9};
//        // Count the amount of prime number satisfied condition
//        int count = 0;
        for (int a : arr) {
            for (int b : arr) {
                for (int c : arr) {
                    for (int d : arr) {
                        for (int e : arr) {
                            for (int f : arr) {
                                int n = a*100000 + b*10000 + c*1000 + d*100 + e*10 +f;
                                if (isPrimeNumber(n)) {
                                    System.out.println(n);
//                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }

//        System.out.println(count);
    }

}
