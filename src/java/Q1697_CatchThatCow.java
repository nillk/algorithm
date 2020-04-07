import java.util.Arrays;
import java.util.Scanner;

public class Q1697_CatchThatCow {
    private static final int MAX = 100005;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] minimum = new int[MAX];
        Arrays.fill(minimum, Integer.MAX_VALUE);
        minimum[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            minimum[i] = n - i;
        }

        for (int i = n + 1; i < MAX; i++) {
            minimum[i] = i - n;
        }

        boolean isAllChecked = false;
        while (!isAllChecked) {
            isAllChecked = true;
            for (int i = 0; i <= MAX / 2; i++) {
                if (minimum[i * 2] > minimum[i] + 1) {
                    minimum[i * 2] = minimum[i] + 1;
                    isAllChecked = false;
                }
            }

            for (int i = 0; i < MAX; i++) {
                if (i < MAX - 1 && minimum[i + 1] > minimum[i] + 1) {
                    minimum[i + 1] = minimum[i] + 1;
                    isAllChecked = false;
                }

                if (i > 0 && minimum[i - 1] > minimum[i] + 1) {
                    minimum[i - 1] = minimum[i] + 1;
                    isAllChecked = false;
                }
            }
        }

        System.out.println(minimum[k]);
    }
}
