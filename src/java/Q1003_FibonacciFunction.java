import java.util.Scanner;
 
public class Q1003_FibonacciFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
 
        int[][] DP = new int[41][2];
        DP[0][0] = 1;
        DP[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            DP[i][0] = DP[i - 1][0] + DP[i - 2][0];
            DP[i][1] = DP[i - 1][1] + DP[i - 2][1];
        }
 
        while (t-- > 0) {
            byte n = scan.nextByte();
            System.out.printf("%d %d\n", DP[n][0], DP[n][1]);
        }
    }
}