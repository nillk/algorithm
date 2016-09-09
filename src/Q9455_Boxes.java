import java.util.Scanner;

public class Q9455_Boxes {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		while (T-- > 0) {
			byte m = scan.nextByte();
			byte n = scan.nextByte();
			scan.nextLine();
			boolean[][] boxes = new boolean[m][n];
			for (byte row = 0; row < m; row++) {
				String[] line = scan.nextLine().split(" ");
				for (byte col = 0; col < n; col++) {
					if ("1".equals(line[col])) {
						boxes[row][col] = true;
					}
				}
			}

			int boxesCount = 0;
			for (byte col = 0; col < n; col++) {
				int rowCount = 0;
				int count = 0;
				for (byte row = (byte) (m - 1); row >= 0; row--) {
					if (boxes[row][col]) {
						rowCount += count;
					} else {
						count++;
					}
				}
				boxesCount += rowCount;
			}

			System.out.println(boxesCount);
		}
		scan.close();
	}
}
