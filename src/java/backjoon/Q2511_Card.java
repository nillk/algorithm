package backjoon;

import java.util.Scanner;

public class Q2511_Card {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] cardA = scan.nextLine().split(" ");
		String[] cardB = scan.nextLine().split(" ");

		char lastWinner = 'D';
		byte scoreA = 0;
		byte scoreB = 0;

		for (byte i = 0; i < 10; i++) {
			if (cardA[i].equals(cardB[i])) {
				scoreA++;
				scoreB++;
			} else if (cardA[i].compareTo(cardB[i]) > 0) {
				scoreA += 3;
				lastWinner = 'A';
			} else {
				scoreB += 3;
				lastWinner = 'B';
			}
		}

		char winner = scoreA == scoreB ? lastWinner : scoreA > scoreB ? 'A' : 'B';
		System.out.printf("%d %d\n%c", scoreA, scoreB, winner);

		scan.close();
	}
}
