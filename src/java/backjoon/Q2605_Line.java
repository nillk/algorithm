package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2605_Line {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte studentNum = scan.nextByte();
		List<Integer> line = new ArrayList<Integer>();

		for (int std = 1; std <= studentNum; std++) {
			byte num = scan.nextByte();
			line.add(std - num - 1, std);
		}

		for (Integer std : line) {
			System.out.printf("%d ", std);
		}
		scan.close();
	}
}
