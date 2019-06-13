import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q1260_DFSBFS {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short theNumberOfV = scan.nextShort();
        int theNumberOfEdge = scan.nextInt();
        int startV = scan.nextInt();

        boolean[][] adjacencyMatrix = new boolean[theNumberOfV][theNumberOfV];

        for (int e = 0; e < theNumberOfEdge; e++) {
            short i = scan.nextShort();
            short j = scan.nextShort();
            adjacencyMatrix[i - 1][j - 1] = true;
            adjacencyMatrix[j - 1][i - 1] = true;
        }

        List<Integer> dfs = DFS(startV, adjacencyMatrix, theNumberOfV);
        List<Integer> bfs = BFS(startV, adjacencyMatrix, theNumberOfV);

        for (Integer d : dfs) {
            System.out.printf("%d ", d);
        }

        System.out.println();

        for (Integer b : bfs) {
            System.out.printf("%d ", b);
        }
    }

    private static List<Integer> DFS(int startV, boolean[][] adjacencyMartix, short theNumberOfV) {
        List<Integer> visitResult = new ArrayList<Integer>();
        boolean[] visit = new boolean[theNumberOfV];

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(startV);
        visitResult.add(startV);
        visit[startV - 1] = true;

        while (!stack.isEmpty()) {
            startV = stack.peek();

            for (int i = 0; i < theNumberOfV; i++) {
                if (adjacencyMartix[startV - 1][i] && !visit[i]) {
                    visitResult.add(i + 1);
                    visit[i] = true;
                    stack.add(i + 1);
                    startV = i + 1;
                    i = -1;
                }
            }
            stack.pop();
        }
        return visitResult;
    }

    private static List<Integer> BFS(int startV, boolean[][] adjacencyMartix, short theNumberOfV) {
        List<Integer> visitResult = new ArrayList<Integer>();
        boolean[] visit = new boolean[theNumberOfV];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startV);
        visit[startV - 1] = true;

        while (!queue.isEmpty()) {
            startV = queue.poll();
            visitResult.add(startV);

            for (int i = 0; i < theNumberOfV; i++) {
                if (adjacencyMartix[startV - 1][i] && !visit[i]) {
                    visit[i] = true;
                    queue.add(i + 1);
                }
            }
        }
        return visitResult;
    }
}
