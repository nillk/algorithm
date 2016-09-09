import java.util.Arrays;
import java.util.Scanner;

public class Q4342_EuclidGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] euclidNum = new int[2];
		euclidNum[0] = scan.nextInt();
		euclidNum[1] = scan.nextInt();

		while (euclidNum[0] != 0 && euclidNum[1] != 0) {
			if (euclidGame(euclidNum)) {
				System.out.println("A wins");
			} else {
				System.out.println("B wins");
			}

			euclidNum[0] = scan.nextInt();
			euclidNum[1] = scan.nextInt();
		}
		scan.close();
	}

	private static boolean euclidGame(int[] euclidNum) {
		Arrays.sort(euclidNum);

		if (euclidNum[1] % euclidNum[0] == 0) {
			return true;
		}

		if (euclidNum[1] - euclidNum[0] < euclidNum[0]) {
			euclidNum[1] -= euclidNum[0];
			return !euclidGame(euclidNum);
		}

		return true;
	}
}
