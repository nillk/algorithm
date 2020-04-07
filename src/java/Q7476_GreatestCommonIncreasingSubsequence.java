import java.util.Scanner;

public class Q7476_GreatestCommonIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        short m1 = scan.nextShort();
        int[] sequence1 = new int[m1];
        for (short i = 0; i < m1; i++) {
            sequence1[i] = scan.nextInt();
        }

        short m2 = scan.nextShort();
        int[] sequence2 = new int[m2];
        for (short i = 0; i < m2; i++) {
            sequence2[i] = scan.nextInt();
        }

        int[][] gcis = new int[m1 + 1][m2 + 1];
        int[][][] offset = new int[m1 + 1][m2 + 1][2];
        int maxLength = 0;
        int offsetRow = 0;
        int offsetCol = 0;

        for (int row = 1; row <= m1; row++) {
            for (int col = 1; col <= m2; col++) {
                if (sequence1[row - 1] == sequence2[col - 1]) {
                    int currentLength = 1;
                    int preRow = 0;
                    int preCol = 0;
                    for (int tmp = row - 1; tmp > 0; tmp--) {
                        if (sequence1[tmp - 1] < sequence1[row - 1] && gcis[tmp][col - 1] + 1 > currentLength) {
                            currentLength = gcis[tmp][col - 1] + 1;
                            preRow = tmp;
                            preCol = col - 1;
                        }
                    }
                    gcis[row][col] = currentLength;
                    offset[row][col][0] = preRow;
                    offset[row][col][1] = preCol;
                } else {
                    gcis[row][col] = gcis[row][col - 1];
                    offset[row][col][0] = row;
                    offset[row][col][1] = col - 1;
                }

                if (maxLength < gcis[row][col]) {
                    offsetRow = row;
                    offsetCol = col;
                    maxLength = gcis[row][col];
                }
            }
        }

        int[] result = new int[maxLength];
        int index = maxLength - 1;
        while (offsetRow != 0 && offsetCol != 0) {
            if (sequence1[offsetRow - 1] == sequence2[offsetCol - 1]) {
                result[index--] = sequence1[offsetRow - 1];
            }
            int[] prevOffset = offset[offsetRow][offsetCol];
            offsetRow = prevOffset[0];
            offsetCol = prevOffset[1];
        }

        System.out.println(maxLength);
        for (int i = 0; i < maxLength; i++) {
            System.out.print(result[i]);
            if (i != maxLength - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}