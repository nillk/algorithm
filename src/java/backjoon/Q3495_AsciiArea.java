package backjoon;

import java.util.Scanner;

public class Q3495_AsciiArea {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte h = scan.nextByte();
        byte w = scan.nextByte();
        char[][] memo = new char[h][w];

        for (byte i = 0; i < h; i++) {
            memo[i] = scan.next().toCharArray();
        }

        int area = 0;
        boolean isArea = false;
        for (byte i = 0; i < h; i++) {
            for (byte j = 0; j < w; j++) {
                if (memo[i][j] == '/' || memo[i][j] == '\\') {
                    isArea = !isArea;
                    area += 0.5;
                }

                if (isArea) {
                    area += 1;
                }
            }
        }

        System.out.println(area);

        scan.close();
    }
}
