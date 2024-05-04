package backjoon;

import java.util.Scanner;

public class Q1535_Hello2 {
    static final byte MAX_STAMINA = 100;
    static int[][] DP;
    static int[] STAMINA;
    static int[] PLEASURE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = scan.nextByte(); // <= 20

        DP = new int[n + 1][MAX_STAMINA];
        STAMINA = new int[n + 1];
        PLEASURE = new int[n + 1];

        for (byte i = 1; i <= n; i++) {
            STAMINA[i] = scan.nextInt();
        }

        for (byte i = 1; i <= n; i++) {
            PLEASURE[i] = scan.nextInt();
        }

        for (byte people = 1; people <= n; people++) {
            for (byte st = 1; st < MAX_STAMINA; st++) {
                if (STAMINA[people] <= st) {
                    DP[people][st] = Math.max(DP[people - 1][st], DP[people - 1][st - STAMINA[people]] + PLEASURE[people]);
                } else {
                    DP[people][st] = DP[people - 1][st];
                }
            }
        }

        System.out.println(DP[n][MAX_STAMINA - 1]);
    }
}
