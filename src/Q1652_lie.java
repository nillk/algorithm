import java.util.Scanner;

public class Q1652_lie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = scan.nextByte();
        boolean[][] room = new boolean[n][n];
        int vertical = 0;
        int horizontal = 0;
        for (byte i = 0; i < n; i++) {
            String line = scan.next();
            int count = 0;
            boolean oneLine = true;
            for (byte j = 0; j < n; j++) {
                if (line.charAt(j) == 'X') {
                    room[i][j] = true;
                    count = 0;
                    oneLine = true;
                } else {
                    count++;
                    if (count >= 2 && oneLine) {
                        horizontal++;
                        oneLine = false;
                    }
                }
            }
        }

        for (byte i = 0; i < n; i++) {
            int count = 0;
            boolean oneLine = true;
            for (byte j = 0; j < n; j++) {
                if (room[j][i]) {
                    count = 0;
                    oneLine = true;
                } else {
                    count++;
                    if (count >= 2 && oneLine) {
                        vertical++;
                        oneLine = false;
                    }
                }
            }
        }

        System.out.printf("%d %d", horizontal, vertical);
    }
}
