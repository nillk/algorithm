import java.util.Scanner;

public class Q1463_MakeOne {
	private static int[] cache;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int X = scan.nextInt();
		cache = new int[X + 1];
		
		System.out.println(solve(X));
		scan.close();
	}

	private static int solve(int x) {
		if (x == 0) return 0;
		if (x == 1 || x == 2 || x == 3) return 1;
		
		if (cache[x] != 0) return cache[x];

		int oneLess = solve(x - 1);
		int div2 = Integer.MAX_VALUE;
		int div3 = Integer.MAX_VALUE;
		if (x % 2 == 0) {
			div2 = solve(x/2);
		}
		if (x % 3 == 0) {
			div3 = solve(x/3);
		}
		
		return cache[x] = 1 + min(oneLess, div2, div3);
	}
	
	private static int min(int a, int b, int c) {
		if (a < b) {
			if (a < c) return a;
			else return c;
		} else { // a > b
			if (b < c) return b;
			else return c;
		}
	}
}
