package backjoon;

import java.util.Scanner;

public class Q1110_PlusCycle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        byte n = scan.nextByte();
        byte[] plusCycle = new byte[2];
        int count = 0;

        if (n / 10 < 1) {
            plusCycle[0] = 0;
            plusCycle[1] = n;
        } else {
            plusCycle[0] = (byte) (n / 10);
            plusCycle[1] = (byte) (n % 10);
        }

        do {
            byte tmp = (byte) (plusCycle[0] + plusCycle[1]);
            plusCycle[0] = plusCycle[1];
            plusCycle[1] = (byte) (tmp % 10);

            count++;
        } while (n != plusCycle[0] * 10 + plusCycle[1]);

        System.out.println(count);
    }
}
