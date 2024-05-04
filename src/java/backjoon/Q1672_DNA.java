package backjoon;

import java.util.Scanner;
 
public class Q1672_DNA {
    public static void main(String[] args) {
        byte[][] dnaTable = new byte[][] {
            {0, 2, 0, -1, 1},
            {2, 1, 4, -1, 0},
            {0, 4, 2, -1, 1},
            {-1},
            {1, 0, 1, -1, 4}
        };
         
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
         
        char[] dna = scan.next().toCharArray();
        int decode = dnaTable[dna[n-1]%5][dna[n-2]%5];
        for (int i = n-2; i > 0; i--) {
            decode = dnaTable[decode][dna[i-1]%5];
        }
         
        System.out.println(toDnaCode(decode));
         
        scan.close();
    }
     
    private static char toDnaCode(int decode) {
        switch (decode) {
        case 0:
            return 'A';
        case 1:
            return 'G';
        case 2:
            return 'C';
        case 4:
            return 'T';
        }
         
        return 'x';
    }
}