package backjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Q8611_Palindroliczby {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger n = scan.nextBigInteger();

        boolean atLeastOnePalindrome = false;
        for (byte base = 2; base < 10; base++) {
            String baseNotation = baseNotation(n, new BigInteger(String.valueOf(base)));
            if (isPalindrome(baseNotation)) {
                System.out.printf("%d %s\n", base, baseNotation);
                atLeastOnePalindrome = true;
            }
        }

        if (isPalindrome(String.valueOf(n))) {
            System.out.printf("%d %s\n", 10, n);
            atLeastOnePalindrome = true;
        }

        if (!atLeastOnePalindrome) {
            System.out.println("NIE");
        }

        scan.close();
    }

    private static String baseNotation(BigInteger n, BigInteger base) {
        StringBuilder sb = new StringBuilder();
        while (n.compareTo(base) != -1) {
            BigInteger[] divideAndRemainder = n.divideAndRemainder(base);
            sb.append(divideAndRemainder[1]);
            n = divideAndRemainder[0];
        }
        sb.append(n);

        return sb.reverse().toString();
    }

    private static boolean isPalindrome(String str) {
        int strLength = str.length();
        int centerIndex = strLength / 2;
        for (int i = 0; i < centerIndex; i++) {
            if (str.charAt(i) != str.charAt(strLength - i - 1)) return false;
        }

        return true;
    }
}
