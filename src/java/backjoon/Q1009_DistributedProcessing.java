package backjoon;

import java.util.Scanner;
 
public class Q1009_DistributedProcessing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte[][] lastNum = new byte[][] {
                {10},
                {1},
                {6, 2, 4, 8},
                {1, 3, 9, 7},
                {6, 4},
                {5},
                {6},
                {1, 7, 9, 3},
                {6, 8, 4, 2},
                {1, 9}};
         
        int t = scan.nextInt();
        byte[] computerNum = new byte[t];
 
        for (int i = 0; i < t; i++) {
            int a = scan.nextInt() % 10;
            int b = scan.nextInt();
             
            int lastNumIndex = b % lastNum[a].length;
            computerNum[i] = lastNum[a][lastNumIndex];
        }
         
        for (int i = 0; i < t; i++) {
            System.out.println(computerNum[i]);
        }
    }
}