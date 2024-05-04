package backjoon;

import java.util.Scanner;

public class Q1978_Primes {
    private static boolean[] PRIMES = new boolean[1001];
    public static void main(String[] args) {
        getPrimes();

        Scanner scan = new Scanner(System.in);
        byte N = scan.nextByte();
        short count = 0;
        for (byte i = 0; i < N; i++) {
            if (PRIMES[scan.nextShort()]) count++;
        }
        System.out.println(count);

        scan.close();
    }

    public static void getPrimes() {
        PRIMES[2] = true;
        for (short i = 3; i < 1001; i += 2) {
            PRIMES[i] = true;
        }
        for (short i = 3; i < 1001; i += 2) {
            if (!PRIMES[i]) continue;
            for (short j = (short) (i * 2); j < 1001; j += i) {
                PRIMES[j] = false;
            }
        }
    }
}
