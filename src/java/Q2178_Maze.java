import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178_Maze {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = scan.nextByte();
        byte m = scan.nextByte();

        boolean[][] maze = new boolean[n][m];
        for (byte row = 0; row < n; row++) {
            char[] line = scan.next().toCharArray();
            for (byte col = 0; col < m; col++) {
                if (line[col] == '1') {
                    maze[row][col] = true;
                }
            }
        }

        Queue<int[]> q = new LinkedList<int[]>();
        boolean[][] visited = new boolean[n][m];
        int[][] count = new int[n][m];
        count[0][0] = 1;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] currentLoc = q.poll();
            int row = currentLoc[0];
            int col = currentLoc[1];
            visited[row][col] = true;

            int nextCount = count[row][col] + 1;

            if (row > 0 && maze[row - 1][col] && !visited[row - 1][col]) {
                q.add(new int[]{row - 1, col});
                count[row - 1][col] = nextCount;
                visited[row - 1][col] = true;
            }
            if (col > 0 && maze[row][col - 1] && !visited[row][col - 1]) {
                q.add(new int[]{row, col - 1});
                count[row][col - 1] = nextCount;
                visited[row][col - 1] = true;
            }
            if (row < n - 1 && maze[row + 1][col] && !visited[row + 1][col]) {
                q.add(new int[]{row + 1, col});
                count[row + 1][col] = nextCount;
                visited[row + 1][col] = true;
            }
            if (col < m - 1 && maze[row][col + 1] && !visited[row][col + 1]) {
                q.add(new int[]{row, col + 1});
                count[row][col + 1] = nextCount;
                visited[row][col + 1] = true;
            }
        }

        System.out.println(count[n - 1][m - 1]);
    }
}
