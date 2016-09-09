import java.util.Scanner;

public class Q2953_ImChef {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte n = 0;
		int score = 0;

		for (byte i = 0; i < 5; i++) {
			int tmp = scan.nextInt() + scan.nextInt() + scan.nextInt() + scan.nextInt();

			if (tmp > score) {
				n = i;
				score = tmp;
			}
		}

		System.out.println(n + 1 + " " + score);
		scan.close();
	}
}
