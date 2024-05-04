package leetcode;

import java.util.Arrays;

public class Q66_PlusOne {

    public static int[] plusOne(int[] digits) {
        int acc = (digits[digits.length - 1] + 1) / 10;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;

        int index = digits.length - 2;
        while (acc > 0 && index >= 0) {
            acc = (digits[index] + acc) / 10;
            digits[index] = (digits[index] + acc) % 10;
            index--;
        }

        if (acc > 0) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = acc;
            return newDigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {8, 9, 9, 9})));
    }
}
