package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1100_WhiteSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (byte i = 0; i < 8; i++) {
            sb.append(br.readLine());
        }

        byte count = 0;
        boolean isZeroStart = true;
        for (byte i = 0; i < 64; i++) {
            if (i != 0 && i % 8 == 0) {
                isZeroStart = !isZeroStart;
            }
            if (isZeroStart && i % 2 == 0) {
                if (sb.charAt(i) == 'F') count++;
            } else if (!isZeroStart && i % 2 != 0) {
                if (sb.charAt(i) == 'F') count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}