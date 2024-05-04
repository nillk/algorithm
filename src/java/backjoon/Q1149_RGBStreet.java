package backjoon;

import java.util.Scanner;

public class Q1149_RGBStreet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short n = scan.nextShort();
        int[][] cost = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            cost[i][0] = scan.nextInt();
            cost[i][1] = scan.nextInt();
            cost[i][2] = scan.nextInt();
        }

        int[][] DP = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            DP[i][0] = cost[i][0] + Math.min(DP[i - 1][1], DP[i - 1][2]);
            DP[i][1] = cost[i][1] + Math.min(DP[i - 1][0], DP[i - 1][2]);
            DP[i][2] = cost[i][2] + Math.min(DP[i - 1][0], DP[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(DP[n][0], DP[n][1]), DP[n][2]));
    }
}