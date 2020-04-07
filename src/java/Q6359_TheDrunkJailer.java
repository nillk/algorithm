import java.util.Scanner;

public class Q6359_TheDrunkJailer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while (T-- > 0) {
			byte n = scan.nextByte();
			System.out.println(getFreePrisoners(n));
		}
		scan.close();
	}

	private static byte getFreePrisoners(byte n) {
		boolean[] room = new boolean[n + 1];

		for (short i = 1; i <= n; i++) {
			for (short j = i; j <= n; j += i) {
				room[j] = !room[j];
			}
		}

		byte count = 0;
		for (byte i = 1; i <= n; i++) {
			if (room[i])
				count++;
		}

		return count;
	}
}
