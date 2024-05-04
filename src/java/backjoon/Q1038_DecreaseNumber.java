package backjoon;

import java.util.Scanner;
 
public class Q1038_DecreaseNumber {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
         
        if (n <= 9) {
            System.out.println(n);
        } else {
            int[][] countArr = new int[10][10];
            for (int i = 0; i < 10; i++) {
                countArr[0][i] = 1;
                countArr[i][i] = 1;
            }
 
            int count = 9;
            boolean isFind = false;
            for (int i = 1; i < 10 && !isFind; i++) {
                for (int j = i; j < 10; j++) {
                    countArr[i][j] = countArr[i][j - 1] + countArr[i - 1][j - 1];
                    if (count + countArr[i][j] >= n) {
                        System.out.print((long) (j * Math.pow(10, i) + findDecreaseNumber(countArr, i - 1, n - count) - 1));
                        isFind = true;
                        break;
                    } else {
                        count += countArr[i][j];
                    }
                }
            }
             
            if (!isFind) {
                System.out.println(-1);
            }
        }
    }
 
    private static int findDecreaseNumber(int[][] array, int row, int n) {
        if (row <= 0) {
            return n;
        } else {
            int count = 0;
            for (int j = row; j < 10; j++) {
                if (count + array[row][j] >= n) {
                    return (int) (j * Math.pow(10, row) + findDecreaseNumber(array, row - 1, n - count));
                } else {
                    count += array[row][j];
                }
            }
 
            return n;
        }
    }
}