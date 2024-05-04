package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q3778_AnagrammaticDistance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 1; i <= n; i++) {
            char[] str1 = scan.nextLine().toCharArray();
            char[] str2 = scan.nextLine().toCharArray();

            Arrays.sort(str1);
            Arrays.sort(str2);

            int str1Index = 0;
            int str2Index = 0;
            int count = 0;

            while (str1Index != str1.length && str2Index != str2.length) {
                if (str1[str1Index] == str2[str2Index]) {
                    str1Index++;
                    str2Index++;
                    continue;
                } else {
                    if (str1[str1Index] < str2[str2Index]) {
                        str1Index++;
                        count++;
                    } else {
                        str2Index++;
                        count++;
                    }
                }
            }

            count += str1.length - str1Index;
            count += str2.length - str2Index;

            System.out.printf("Case #%d: %d\n", i, count);
        }
    }
}
