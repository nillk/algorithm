package backjoon;

import java.util.Scanner;

public class Q1965_Boxes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short boxCount = scan.nextShort();

        int[] boxSizes = new int[boxCount];
        for (short i = 0; i < boxCount; i++) {
            boxSizes[i] = scan.nextInt();
        }

        int result = -1;
        int[] maxInBoxCount = new int[boxCount];
        for (short i = 0; i < boxCount; i++) {
            int maxLength = 1;
            for (short j = 0; j < i; j++) {
                if (boxSizes[i] > boxSizes[j] && maxInBoxCount[j] + 1 > maxLength) {
                    maxLength = maxInBoxCount[j] + 1;
                }
            }

            maxInBoxCount[i] = maxLength;

            if (maxInBoxCount[i] > result) {
                result = maxInBoxCount[i];
            }
        }

        System.out.println(result);

        scan.close();
    }
}