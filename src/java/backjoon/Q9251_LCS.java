package backjoon;

import java.util.Scanner;

public class Q9251_LCS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] charArr1 = scan.next().toCharArray();
        char[] charArr2 = scan.next().toCharArray();

        int length1 = charArr1.length;
        int length2 = charArr2.length;

        int[][] lcs = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        System.out.println(lcs[length1][length2]);
    }
}