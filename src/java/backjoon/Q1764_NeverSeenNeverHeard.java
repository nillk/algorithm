package backjoon;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Q1764_NeverSeenNeverHeard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        Set<String> neverHeard = new TreeSet<String>();
        for (int i = 0; i < n; i++) {
            neverHeard.add(scan.next());
        }

        Set<String> result = new TreeSet<String>();
        for (int i = 0; i < m; i++) {
            String name = scan.next();
            if (neverHeard.contains(name)) {
                result.add(name);
            }
        }

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}