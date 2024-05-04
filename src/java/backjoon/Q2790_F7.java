package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2790_F7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = scan.nextInt();
        }

        Arrays.sort(score);

        int[] reverseExprectedScore = new int[n];
        for (int i = 0; i < n; i++) {
            reverseExprectedScore[i] = score[i] + (n - i);
        }

        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            int tmpScore = score[i] + n;
            if (tmpScore >= reverseExprectedScore[n - 1]
                    && tmpScore >= reverseExprectedScore[i + 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
}

