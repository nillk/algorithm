import java.util.Scanner;

public class Q2839_SECER {
	static int[] DP;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		short N = scan.nextShort();
		DP = new int[N + 1];
		DP[0] = -1;
		DP[1] = -1;
		DP[2] = -1;
		DP[3] = 1;
		
		if (N > 3) DP[4] = -1;
		if (N > 4) DP[5] = 1;
		
		System.out.println(solve(N));
		
		scan.close();
	}

	private static int solve(int n) {
		if (DP[n] != 0) return DP[n];
		
		int n3 = solve(n - 3);
		int n5 = solve(n - 5);
		
		if (n3 < 0 && n5 < 0) return DP[n] = -1;
		else if (n3 < 0) return DP[n] = n5 + 1;
		else if (n5 < 0) return DP[n] = n3 + 1;
		return DP[n] = Math.min(n3, n5) + 1;
	}
}
