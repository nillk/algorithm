package backjoon;

import java.util.Scanner;
 
public class Q1357_ReverseSum {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short x = scan.nextShort();
        short y = scan.nextShort();
 
        System.out.println(rev(rev(x) + rev(y)));
    }
 
    private static int rev(int num) {
        StringBuilder sb = new StringBuilder();
 
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }
 
        return Integer.parseInt(sb.toString());
    }
}