package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class Q10736_XOR2 {
    // 1 - 2   : 2 - 3
    // 2 - 5   : 4 - 7
    // 4 - 11  : 8 - 15
    // 8 - 23  : 16 - 31
    // 16 - 47 : 32 - 63
    // 32 - 95 : 64 - 100
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
 
        while (t-- > 0) {
            byte n = scan.nextByte();
 
            if (n == 1) {
                System.out.println("1\n1");
            } else {
                int from = (int) Math.pow(2, log2ToInteger(n) - 1);
                int to = Math.min(n, (from + (from * 2)) - 1);
 
                List<Integer> result = new ArrayList<Integer>();
                for (int i = from; i <= to; i++) {
                    result.add(i);
                }
                Collections.sort(result);
 
                int resultSize = result.size();
                System.out.println(resultSize);
                for (int i = 0; i < resultSize - 1; i++) {
                    System.out.print(result.get(i) + " ");
                }
                System.out.println(result.get(resultSize - 1));
            }
        }
 
        scan.close();
    }
 
    private static int log2ToInteger(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}