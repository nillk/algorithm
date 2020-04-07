import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11723_Set {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		boolean[] S = new boolean[21];
		while (M-- > 0) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
			case "add":
				S[Byte.parseByte(command[1])] = true;
				break;
			case "remove":
				S[Byte.parseByte(command[1])] = false;
				break;
			case "check":
				result.append(S[Byte.parseByte(command[1])] ? "1\n" : "0\n");
				break;
			case "toggle":
				byte n = Byte.parseByte(command[1]);
				S[n] = !S[n];
				break;
			case "all":
				Arrays.fill(S, true);
				break;
			case "empty":
				Arrays.fill(S, false);
				break;
			}
		}

		System.out.println(result.toString());
	}
}
