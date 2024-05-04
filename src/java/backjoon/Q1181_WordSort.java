package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181_WordSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Set<String> wordSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o1.length() - o2.length();
            }
        });

        while(N-- > 0) {
            String word = reader.readLine();
            wordSet.add(word);
        }

        StringBuilder result = new StringBuilder();
        for (String w : wordSet) {
            result.append(w).append(System.lineSeparator());
        }

        System.out.println(result.toString());
    }
}
