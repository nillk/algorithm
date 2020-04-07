import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Q2150_StronglyConnectedComponent {
    static int[][] VERTEX;
    static HashMap<Integer, HashSet<Integer>> EDGE = new HashMap<Integer, HashSet<Integer>>();
    static int INDEX = 1;

    static Stack<Integer> stack = new Stack<Integer>();

    static Map<Integer, HashSet<Integer>> SCC = new TreeMap<Integer, HashSet<Integer>>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();

        VERTEX = new int[V + 1][2];
        for (int i = 0; i < V; i++) {
            EDGE.put(i + 1, new HashSet<Integer>());
        }
        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            EDGE.get(from).add(to);
        }

        for (int i = 1; i <= V; i++) {
            if (VERTEX[i][0] == 0) {
                strongConnect(i);
            }
        }

        System.out.println(SCC.size());
        for (HashSet<Integer> value : SCC.values()) {
            printHashSet(value);
        }
    }

    private static void strongConnect(int current) {
        VERTEX[current][0] = INDEX;
        VERTEX[current][1] = INDEX;
        INDEX++;

        stack.push(current);

        Iterator<Integer> iterator = EDGE.get(current).iterator();
        while (iterator.hasNext()) {
            Integer nextCity = iterator.next();
            if (VERTEX[nextCity][0] == 0) {
                strongConnect(nextCity);
                VERTEX[current][1] = Math.min(VERTEX[current][1], VERTEX[nextCity][1]);
            } else if (stack.contains(nextCity)) {
                VERTEX[current][1] = Math.min(VERTEX[current][1], VERTEX[nextCity][0]);
            }
        }

        if (VERTEX[current][0] == VERTEX[current][1]) {
            HashSet<Integer> set = new HashSet<Integer>();
            int w = -1;
            while (current != w) {
                w = stack.pop();
                set.add(w);
            }

            Integer key = Collections.min(set);
            SCC.put(key, set);
        }
    }

    private static void printHashSet(HashSet<Integer> set) {
        Object[] array = set.toArray();
        Arrays.sort(array);

        for (Object arr : array) {
            System.out.print(arr + " ");
        }

        System.out.println(-1);
    }
}