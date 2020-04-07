import java.util.Scanner;

public class Q6064_CainCalendar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t-- > 0) {
            int M = scan.nextInt();
            int N = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();

            int lcm = lcm(M, N);
            boolean isFind = false;
            for (int index = x; index <= lcm; index += M) {
                if (index % N == y % N) {
                    System.out.println(index);
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {
                System.out.println(-1);
            }
        }
        scan.close();
    }

    private static int lcm(int M, int N) {
        int max = Math.max(M, N);
        int min = Math.min(M, N);

        int remaind = -1;
        while (remaind != 0) {
            remaind = max % min;
            max = min;
            min = remaind;
        }

        if (max == 0) {
            return 0;
        }

        return M * N / max;
    }
}