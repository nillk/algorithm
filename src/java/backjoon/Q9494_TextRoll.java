package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q9494_TextRoll {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> answer = new ArrayList<Integer>();

		int lineNum = Integer.parseInt(br.readLine());
		while (lineNum != 0) {
			char[][] text = new char[lineNum][];

			for (short line = 0; line < lineNum; line++) {
				text[line] = br.readLine().toCharArray();
			}

			byte prevCharIndex = 0;
			for (short line = 0; line < lineNum; line++) {
				for (byte charIndex = prevCharIndex; charIndex < text[line].length; charIndex++) {
					if (text[line][charIndex] == ' ') {
						prevCharIndex = charIndex;
						break;
					}

					if (text[line].length - 1 == charIndex) {
						prevCharIndex = (byte) (charIndex + 1);
					}
				}
			}

			answer.add(prevCharIndex + 1);
			lineNum = Integer.parseInt(br.readLine());
		}

		for (Integer ans : answer) {
			System.out.println(ans);
		}
	}
}
