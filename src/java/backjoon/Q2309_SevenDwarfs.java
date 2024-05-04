package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309_SevenDwarfs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        byte[] heights = new byte[9];
        short total = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = scan.nextByte();
            total += heights[i];
        }

        Arrays.sort(heights);

        int i = 0;
        int j = 0;

        FIND:
        for (; i < 9; i++) {
            for (j = 0; j < i; j++) {
                if (total - (heights[i] + heights[j]) == 100) {
                    break FIND;
                }
            }
        }

        for (int k = 0; k < 9; k++) {
            if (k != i && k != j) System.out.println(heights[k]);
        }

        scan.close();
    }
}
