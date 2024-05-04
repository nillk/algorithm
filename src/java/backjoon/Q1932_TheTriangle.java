package backjoon;

import java.util.Scanner;

public class Q1932_TheTriangle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        int[] max = new int[n + 10];
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            String[] str = scan.nextLine().split(" ");
            for (int j = i; j >= 1; j--) {
                max[j] = Math.max(max[j], max[j - 1]) + Integer.parseInt(str[i - j]);
                if (max[j] > maxValue) {
                    maxValue = max[j];
                }
            }
        }

        System.out.println(maxValue);
        scan.close();
    }
}
