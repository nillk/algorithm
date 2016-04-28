import java.util.Scanner;
 
public class Q1001_Turret {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
 
        while (test-- > 0) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int r1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int r2 = scan.nextInt();
 
            double distance = getDistance(x1, y1, x2, y2);
            int diff = Math.abs(r1 - r2);
            int sum = r1 + r2;
 
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (diff < distance && distance < sum) {
                System.out.println(2);
            } else if (sum == distance || diff == distance) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
 
        scan.close();
    }
 
    private static double getDistance(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
 
        return Math.sqrt(dx * dx + dy * dy);
    }
}