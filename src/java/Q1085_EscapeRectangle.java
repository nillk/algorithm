import java.util.Scanner;
 
public class Q1085_EscapeRectangle {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rect = scan.nextLine().split(" ");
        int x = Integer.parseInt(rect[0]);
        int y = Integer.parseInt(rect[1]);
 
        int min = Math.min(1001, Math.min(x, Integer.parseInt(rect[2]) - x));
        min = Math.min(min, Math.min(y, Integer.parseInt(rect[3]) - y));
        System.out.println(min);
        scan.close();
    }
}