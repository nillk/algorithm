import java.util.Arrays;
import java.util.Scanner;

public class Q9764_SumOfDifferentNaturalNumbers {
    static final int N = 2000;
    static final int DIVISOR = 100999;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte tc = scan.nextByte();

        int[] DP = calculateNumberOfCases();
        while (tc-- > 0) {
            short n = scan.nextShort();
            System.out.println(DP[n]);
        }

        scan.close();
    }

    static int[] calculateNumberOfCases() {
        int[] DP = new int[N + 1];
        int[] tmp = new int[N + 1];

        for (int index = 1; index <= N; index++) {
            Arrays.fill(tmp, 0);

            int selectedSum = 0;
            for (int i = 0; i < index; i++) {
                selectedSum += i;
            }

            if (selectedSum <= N) {
                tmp[selectedSum] = 1;
                for (int next = index + 1; next <= N; next++) {
                    for (int sum = N; sum - next >= selectedSum; sum--) {
                        tmp[sum] += (tmp[sum - next] % DIVISOR);
                    }
                }
            } else {
                break;
            }

            for (int i = 1; i <= N; i++) {
                DP[i] += (tmp[i] % DIVISOR);
            }
        }

        for (int i = 1; i <= N; i++) {
            DP[i] %= DIVISOR;
        }

        return DP;
    }
}
