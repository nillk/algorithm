package backjoon;

import java.util.Scanner;

public class Q1958_LCS3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] charArr1 = scan.next().toCharArray();
        char[] charArr2 = scan.next().toCharArray();
        char[] charArr3 = scan.next().toCharArray();

        int length1 = charArr1.length;
        int length2 = charArr2.length;
        int length3 = charArr3.length;

        int[][][] lcs = new int[length1 + 1][length2 + 1][length3 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                for (int k = 1; k <= length3; k++) {
                    if (charArr1[i - 1] == charArr2[j - 1] && charArr2[j - 1] == charArr3[k - 1]) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    } else {
                        lcs[i][j][k] = Math.max(Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]), lcs[i][j][k - 1]);
                    }
                }
            }
        }

        System.out.println(lcs[length1][length2][length3]);
    }
}