import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2167_SumOf2DMatrix {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = reader.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] matrix = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String[] row = reader.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				int tmp = Integer.parseInt(row[j - 1]);
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1] + tmp;
			}
		}

		int K = Integer.parseInt(reader.readLine());
		while (K-- > 0) {
			String[] range = reader.readLine().split(" ");
			int i = Integer.parseInt(range[0]);
			int j = Integer.parseInt(range[1]);
			int x = Integer.parseInt(range[2]);
			int y = Integer.parseInt(range[3]);

			System.out.println(matrix[x][y] - matrix[i - 1][y] - matrix[x][j - 1] + matrix[i - 1][j - 1]);
		}
	}
}
