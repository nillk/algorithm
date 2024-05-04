package backjoon;

import java.util.Scanner;

public class Q2563_ColoredPaper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean[][] whitePaper = new boolean[101][101];
        byte coloredPaper = scan.nextByte();
        while (coloredPaper-- > 0) {
            byte left = scan.nextByte();
            byte bottom = scan.nextByte();
            for (byte deltaX = 0; deltaX < 10; deltaX++) {
                for (byte deltaY = 0; deltaY < 10; deltaY++) {
                    whitePaper[left + deltaX][bottom + deltaY] = true;
                }
            }
        }

        int count = 0;
        for (byte i = 0; i <= 100; i++) {
            for (byte j = 0; j <= 100; j++) {
                if (whitePaper[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}
