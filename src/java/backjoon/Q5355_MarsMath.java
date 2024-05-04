package backjoon;

import java.util.Scanner;

public class Q5355_MarsMath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        while (t-- > 0) {
            String test = scan.nextLine();
            String[] split = test.split(" ");

            double result = Double.parseDouble(split[0]);
            for (int i = 1; i < split.length; i++) {
                switch (split[i]) {
                    case "@":
                        result = at(result);
                        break;
                    case "%":
                        result = percentage(result);
                        break;
                    case "#":
                        result = sharp(result);
                        break;
                }
            }

            System.out.printf("%.2f\n", result);
        }

        scan.close();
    }

    private static double at(double n) {
        return n * 3;
    }

    private static double percentage(double n) {
        return n + 5;
    }

    private static double sharp(double n) {
        return n - 7;
    }
}