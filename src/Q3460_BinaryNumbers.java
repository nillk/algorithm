import java.util.Scanner;

public class Q3460_BinaryNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		byte testCase = scan.nextByte();
		String[] solve = new String[testCase];

		StringBuilder sb = new StringBuilder();
		for (byte i = 0; i < testCase; i++) {
			int test = scan.nextInt();
			String binaryString = Integer.toBinaryString(test);
			int rightMostBitIndex = binaryString.length() - 1;
			for (int j = rightMostBitIndex; j >= 0; j--) {
				if (binaryString.charAt(j) == '1') {
					sb.append(rightMostBitIndex - j).append(" ");
				}
			}

			solve[i] = sb.toString();
			sb.delete(0, sb.length());
		}

		for (String sol : solve) {
			System.out.println(sol);
		}
		
		scan.close();
	}
}
