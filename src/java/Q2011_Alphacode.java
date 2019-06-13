import java.util.Scanner;

public class Q2011_Alphacode {
    private static final int DIV = 1000000;
    private static int[] cache;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String alphacode = scan.nextLine();
        cache = new int[5001];
        System.out.println(solve(alphacode, 0));

        scan.close();
    }

    private static int solve(String alphacode, int index) {
        if (alphacode.length() == 0) return 1;
        if (alphacode.length() == 1) {
            if (Integer.parseInt(alphacode) == 0) return 0;
            else return 1;
        }
        if (alphacode.length() == 2) {
            int value = Integer.parseInt(alphacode);
            if (value == 10 || value == 20) return 1;
            else if (value < 27 && value > 10) return 2;
            else return 1;
        }
        if (cache[index] != 0) {
            return cache[index];
        }

        int num1 = alphacode.charAt(0) - '0';
        int num2 = alphacode.charAt(1) - '0';
        int num3 = alphacode.charAt(2) - '0';
        int num = num1 * 10 + num2;

        if (num3 == 0) {
            return cache[index] = solve(alphacode.substring(3), index + 3) % DIV;
        }
        if (num == 10 || num == 20) {
            return cache[index] = solve(alphacode.substring(2), index + 2) % DIV;
        } else if (10 < num && num < 27) {
            return cache[index] = ((solve(alphacode.substring(1), index + 1) % DIV) + (solve(alphacode.substring(2), index + 2) % DIV)) % DIV;
        } else {
            return cache[index] = solve(alphacode.substring(1), index + 1) % DIV;
        }
    }
}
