package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10871_LessThanX {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		String[] NX = reader.readLine().split(" ");
		int X = Integer.parseInt(NX[1]);

		String[] numbers = reader.readLine().split(" ");
		for (String n : numbers) {
			if (Integer.parseInt(n) < X) {
				result.append(n + " ");
			}
		}
		System.out.println(result.toString());
	}
}
