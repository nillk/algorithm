package backjoon;

import java.util.Scanner;
 
public class Q1008_Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
 
        if (b != 0) {
            System.out.print(a/b);
        }
    }
}