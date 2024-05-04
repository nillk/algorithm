package backjoon;

import java.util.Scanner;

public class Q3687_Matchsticks {
    private static final byte[] MATCHSTICKS = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    private static final short[] MIN = new short[22];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte tc = scan.nextByte();

        initMinArr();
        for (byte i = 8; i < 22; i++) {
            MIN[i] = fillMinArr(i);
        }

        while (tc-- > 0) {
            byte matchsticks = scan.nextByte();
            StringBuilder sb = new StringBuilder();

            findMinimum(matchsticks, sb);
            sb.append(" ");
            findMaximum(matchsticks, sb);

            System.out.println(sb.toString());
        }
    }

    private static void initMinArr() {
        for (byte i = 0; i < 22; i++) {
            MIN[i] = Short.MAX_VALUE;
        }

        for (byte i = 2; i <= 7; i++) {
            for (byte j = 0; j < 10; j++) {
                if (MATCHSTICKS[j] == i && j < MIN[i]) {
                    MIN[i] = j;
                }
            }
        }
    }

    private static short fillMinArr(byte sticks) {
        if (sticks < 2) {
            return Short.MAX_VALUE;
        }
        if (sticks == 6) {
            return 6;
        }
        if (MIN[sticks] != Short.MAX_VALUE) {
            return MIN[sticks];
        }

        short min = Short.MAX_VALUE;
        for (byte i = 2; i < 8; i++) {
            min = (short) Math.min(min, getMinimum(MIN[i], fillMinArr((byte) (sticks - i))));
        }

        return min;
    }

    private static int getMinimum(short i, short j) {
        if (j == 0) {
            return i * 10;
        }
        return i + j * 10;
    }

    public static void findMinimum(int matchsticks, StringBuilder sb) {
        if (matchsticks == 6) {
            sb.append(6);
        } else if (matchsticks <= 14) {
            sb.append(MIN[matchsticks]);
        } else {
            int eightCount = (matchsticks - 14) / 7;
            int prefix = matchsticks % 7 + 14;
            sb.append(MIN[prefix]);
            for (byte i = 0; i < eightCount; i++) {
                sb.append(8);
            }
        }
    }

    public static void findMaximum(byte matchsticks, StringBuilder sb) {
        if (matchsticks % 2 == 0) {
            for (byte i = 0; i < matchsticks / 2; i++) {
                sb.append(1);
            }
        } else {
            sb.append(7);
            for (byte i = 0; i < (matchsticks / 2) - 1; i++) {
                sb.append(1);
            }
        }
    }
}