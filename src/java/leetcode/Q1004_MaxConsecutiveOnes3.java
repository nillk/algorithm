package leetcode;

public class Q1004_MaxConsecutiveOnes3 {
    public static int longestOnes(int[] A, int K) {
        int j = 0, i;
        for (i = 0; i < A.length; i++) {
            if (A[i] == 0) K--;
            if (K < 0) {
                if (A[j] == 0) K++;
                j++;
            }
        }

        return i - j;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0}, 2));
    }
}