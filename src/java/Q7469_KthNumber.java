import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7469_KthNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = reader.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		KthArray[] arr = new KthArray[N];
		String[] arrStr = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = new KthArray(i + 1, Integer.parseInt(arrStr[i]));
		}

		Arrays.sort(arr);

		while (M-- > 0) {
			String[] q = reader.readLine().split(" ");
			int left = Integer.parseInt(q[0]);
			int right = Integer.parseInt(q[1]);
			int count = Integer.parseInt(q[2]);

			for (int i = 0; i < N; i++) {
				if (arr[i].index >= left && arr[i].index <= right) {
					count--;
					if (count == 0) {
						System.out.println(arr[i].value);
						break;
					}
				}
			}
		}
	}
}

class KthArray implements Comparable<KthArray> {
	int index;
	int value;

	public KthArray(int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(KthArray o) {
		return this.value - o.value;
	}
}
