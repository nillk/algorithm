package backjoon;

import java.util.Scanner;

public class Q2477_OrientalMelon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte orientalMelon = scan.nextByte();

        byte[] farmShape = new byte[12];
        short[] farmLength = new short[6];
        for (byte i = 0; i < 6; i++) {
            farmShape[i] = scan.nextByte();
            farmShape[i + 6] = farmShape[i];
            farmLength[i] = scan.nextShort();
        }

        byte vertex = findVertex(farmShape);
        int minus = farmLength[vertex] * farmLength[(vertex + 1) % 6];
        int whole = farmLength[(vertex + 3) % 6] * farmLength[(vertex + 4) % 6];

        System.out.println((whole - minus) * orientalMelon);
    }

    private static byte findVertex(byte[] farmShape) {
        for (byte i = 0; i < 9; i++) {
            if (farmShape[i] == farmShape[i + 2] && farmShape[i + 1] == farmShape[i + 3]) {
                return (byte) ((i + 1) % 6);
            }
        }

        return -1;
    }
}
