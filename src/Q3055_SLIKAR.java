import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3055_SLIKAR {
    static Queue<Point> PAINTER = new LinkedList<Point>();
    static Queue<Point> WATER = new LinkedList<Point>();
    static boolean[][] VISITED;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte R = scan.nextByte();
        byte C = scan.nextByte();
        char[][] map = new char[R][C];
        VISITED = new boolean[R][C];

        scan.nextLine();
        for (byte row = 0; row < R; row++) {
            String tmpRow = scan.nextLine();
            for (byte col = 0; col < C; col++) {
                map[row][col] = tmpRow.charAt(col);
                if (map[row][col] == 'S') {
                    PAINTER.add(new Point(row, col, 0));
                } else if (map[row][col] == '*') {
                    WATER.add(new Point(row, col, 0));
                }
            }
        }

        int minimum = Integer.MAX_VALUE;
        while (!PAINTER.isEmpty() && minimum == Integer.MAX_VALUE) {
            int size = WATER.size();
            for (int i = 0; i < size; i++) {
                Point tmp = WATER.poll();
                waterFlood(map, tmp.row - 1, tmp.col);
                waterFlood(map, tmp.row + 1, tmp.col);
                waterFlood(map, tmp.row, tmp.col - 1);
                waterFlood(map, tmp.row, tmp.col + 1);
            }

            int painterSize = PAINTER.size();
            for (int i = 0; i < painterSize; i++) {
                Point painter = PAINTER.poll();
                int move = move(map, painter.row - 1, painter.col, painter.cost);
                if (move != -1) minimum = Math.min(move, minimum);
                move = move(map, painter.row + 1, painter.col, painter.cost);
                if (move != -1) minimum = Math.min(move, minimum);
                move = move(map, painter.row, painter.col - 1, painter.cost);
                if (move != -1) minimum = Math.min(move, minimum);
                move = move(map, painter.row, painter.col + 1, painter.cost);
                if (move != -1) minimum = Math.min(move, minimum);
            }
        }

        System.out.println(minimum == Integer.MAX_VALUE ? "KAKTUS" : minimum);

        scan.close();
    }

    public static void waterFlood(char[][] map, int row, int col) {
        if (row >= 0 && row < map.length && col >= 0 && col < map[row].length) {
            if (!VISITED[row][col] && (map[row][col] == '.' || map[row][col] == 'S')) {
                map[row][col] = '*';
                WATER.add(new Point(row, col, 0));
            }
        }
    }

    public static int move(char[][] map, int row, int col, int cost) {
        if (row >= 0 && row < map.length && col >= 0 && col < map[row].length) {
            if (map[row][col] == '.' && !VISITED[row][col]) {
                PAINTER.add(new Point(row, col, cost + 1));
                VISITED[row][col] = true;
                return -1;
            } else if (map[row][col] == 'D') {
                return cost + 1;
            }
        }

        return -1;
    }
}

class Point {
    int row;
    int col;
    int cost;

    public Point(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}
