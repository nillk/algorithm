package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1158_JosephusProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] josephus = new boolean[n];

        int index = -1;
        while (result.size() != n) {
            int count = 0;
            while (true) {
                index = (index == n - 1) ? 0 : index + 1;

                if (!josephus[index]) {
                    count++;
                }

                if (count == m  && !josephus[index]) {
                    result.add(index + 1);
                    josephus[index] = true;
                    break;
                }
            }
        }

        String josephusStr = Arrays.toString(result.toArray());
        josephusStr = josephusStr.replace('[', '<');
        josephusStr = josephusStr.replace(']', '>');

        System.out.println(josephusStr);
    }
}
