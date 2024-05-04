package backjoon;

import java.util.Scanner;

public class Q1535_Hello {
    static final byte MAX_STAMINA = 100;
    static int[] STAMINA;
    static int[] PLEASURE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = scan.nextByte(); // <= 20

        STAMINA = new int[n + 1];
        PLEASURE = new int[n + 1];

        for (byte i = 0; i < n; i++) {
            STAMINA[i] = scan.nextInt();
        }

        for (byte i = 0; i < n; i++) {
            PLEASURE[i] = scan.nextInt();
        }

        System.out.println(calMaxPleasure(n, MAX_STAMINA));
    }

    private static int calMaxPleasure(byte people, int leftStamina) {
        if (people <= 0 || leftStamina < 0) {
            return 0;
        }
        if (leftStamina - STAMINA[people] <= 0) {
            return calMaxPleasure((byte) (people - 1), leftStamina);
        } else {
            return Math.max(calMaxPleasure((byte) (people - 1), leftStamina), calMaxPleasure((byte) (people - 1), leftStamina - STAMINA[people]) + PLEASURE[people]);
        }
    }
}
