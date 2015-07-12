import java.util.Scanner;
import java.util.Stack;

public class Q10728_XOR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[][] xor = new int[25][3]; // 0 : currentXor, 1 : offset, 2 : length

        for (byte i = 0; i < 25; i++) {
            xor[i][0] = -1;
            xor[i][1] = -1;
            xor[i][2] = 1;
        }

        xor[1][0] = 1;

        for (int i = 1; i < 25; i++) {
            for (int j = 1; j < i; j++) {
                if ((xor[j][0] ^ i) > 0) {
                    if (xor[j][2] + 1 > xor[i][2]) {
                        xor[i][0] = xor[j][0] ^ i;
                        xor[i][1] = j;
                        xor[i][2] = xor[j][2] + 1;
                    }
                }
            }
        }

        while (t-- > 0) {
            printXor(xor, scan.nextByte());
        }
    }

    private static void printXor(int[][] xor, byte n) {
        int maxOffset = -1;
        int maxLength = 1;
        for (int i = 0; i <= n; i++) {
            if (xor[i][2] > maxLength) {
                maxLength = xor[i][2];
                maxOffset = i;
            }
        }

        Stack<Integer> result = new Stack<Integer>();
        while (maxOffset > 0) {
            result.push(maxOffset);
            maxOffset = xor[maxOffset][1];
        }

        System.out.println(result.size());
        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}
