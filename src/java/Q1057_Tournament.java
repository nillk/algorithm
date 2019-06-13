import java.util.Scanner;
 
public class Q1057_Tournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
 
        int count = 0;
        while (a != b) {
            count++;
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
        }
 
        System.out.println(count);
        scan.close();
    }
}