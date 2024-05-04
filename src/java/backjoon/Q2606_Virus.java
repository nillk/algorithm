package backjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q2606_Virus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte computers = scan.nextByte();
        int networks = scan.nextInt();
        boolean[][] networkMatrix = new boolean[computers][computers];

        for (int i = 0; i < networks; i++) {
            byte com1 = scan.nextByte();
            byte com2 = scan.nextByte();

            networkMatrix[com1 - 1][com2 - 1] = true;
            networkMatrix[com2 - 1][com1 - 1] = true;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        q.add(0);

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            for (int i = 0; i < computers; i++) {
                if (networkMatrix[currentNode][i] && !result.contains(i) && i != currentNode) {
                    q.add(i);
                    result.add(i);
                }
            }
        }

        result.remove(0);

        System.out.println(result.size());
    }
}
