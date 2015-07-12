import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q8462_PowerfulArray {
    private static long[] COUNT = new long[1000001];
    private static int[] A;
    private static int[][] RANGE;
    private static int LEFT, RIGHT;
    private static int SR;
    private static long RESULT = 0;
    private static long[] ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nt = br.readLine().split(" ");
        int n = Integer.parseInt(nt[0]);
        int t = Integer.parseInt(nt[1]);
        SR = (int) Math.sqrt(n);

        String[] arr = br.readLine().split(" ");
        A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(arr[i - 1]);
        }

        RANGE = new int[t][3];
        for (int i = 0; i < t; i++) {
            String[] range = br.readLine().split(" ");
            RANGE[i][0] = Integer.parseInt(range[0]);
            RANGE[i][1] = Integer.parseInt(range[1]);
            RANGE[i][2] = i;
        }

        Arrays.sort(RANGE, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] / SR < o2[0] / SR) {
                    return 1;
                }
                if (o1[0] / SR > o2[0] / SR) {
                    return -1;
                }

                return o2[1] - o1[1];
            }
        });

        ANSWER = new long[t];
        for (int i = 0; i < t; i++) {
            while (RIGHT < RANGE[i][1]) {
                RIGHT++;
                RESULT += ((COUNT[A[RIGHT]] << 1) | 1) * A[RIGHT];
                COUNT[A[RIGHT]]++;
            }
            while (RIGHT > RANGE[i][1]) {
                COUNT[A[RIGHT]]--;
                RESULT -= ((COUNT[A[RIGHT]] << 1) | 1) * A[RIGHT];
                RIGHT--;
            }
            while (LEFT < RANGE[i][0]) {
                COUNT[A[LEFT]]--;
                RESULT -= ((COUNT[A[LEFT]] << 1) | 1) * A[LEFT];
                LEFT++;
            }
            while (LEFT > RANGE[i][0]) {
                LEFT--;
                RESULT += ((COUNT[A[LEFT]] << 1) | 1) * A[LEFT];
                COUNT[A[LEFT]]++;
            }
            ANSWER[RANGE[i][2]] = RESULT;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(ANSWER[i]);
            if (i != t - 1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}