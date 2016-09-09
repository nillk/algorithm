import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q2776_Memorization {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			br.readLine();
			String note1Str = br.readLine();
			br.readLine();
			String note2Str = br.readLine();

			Set<Integer> note1 = new HashSet<Integer>();
			StringTokenizer st = new StringTokenizer(note1Str);
			while (st.hasMoreTokens()) {
				note1.add(Integer.parseInt(st.nextToken()));
			}

			StringTokenizer st2 = new StringTokenizer(note2Str);
			while (st2.hasMoreTokens()) {
				if (note1.contains(Integer.parseInt(st2.nextToken()))) {
					result.append("1\n");
				} else {
					result.append("0\n");
				}
			}
		}
		System.out.println(result.toString());
	}
}
