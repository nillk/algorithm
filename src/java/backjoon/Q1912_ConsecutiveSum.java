package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Q1912_ConsecutiveSum {

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = nextInt();
        int[] data = nextIntArray(n);

        int[] memo = new int[n];

        int max = data[0];
        memo[0] = data[0];
        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(data[i], memo[i - 1] + data[i]);
            max = Math.max(memo[i], max);
        }

        writer.write(String.valueOf(max));

        writer.flush();
        writer.close();
        reader.close();
    }

    static BufferedReader reader;
    static BufferedWriter writer;

    static StringTokenizer st;

    private static String next() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(reader.readLine());
        }

        return st.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static int[] nextIntArray(int n) throws IOException {
        int[] data = new int[n];

        for (int i = 0; i < n; i++) data[i] = nextInt();

        return data;
    }
}