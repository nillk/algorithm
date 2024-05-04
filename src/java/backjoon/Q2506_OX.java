package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2506_OX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine(); // ignore N

        String score = reader.readLine();
        int sum = Arrays.stream(score.replace(" ", "").split("0"))
                .map(n -> ((n.length() * (n.length() + 1)) / 2))
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
