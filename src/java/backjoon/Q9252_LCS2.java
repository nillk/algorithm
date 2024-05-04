package backjoon;

import java.util.Scanner;

public class Q9252_LCS2 {
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
        StringBuffer sb = new StringBuffer();
        int row = length1;
        int col = length2;
        while (row != 0 && col != 0) {
            if (charArr1[row - 1] == charArr2[col - 1]) {
                sb.append(charArr1[row - 1]);
                row--;
                col--;
            } else if (lcs[row - 1][col] >= lcs[row][col - 1]) {
                row--;
            } else {
                col--;
            }
        }

        System.out.println(sb.reverse().toString());
    }
}