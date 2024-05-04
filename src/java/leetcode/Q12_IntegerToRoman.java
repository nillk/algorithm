package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q12_IntegerToRoman {

    Map<Integer, String> romanMap = new LinkedHashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    int[] keys = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int curr = keys[index++];

        while (num > 0) {
            if (num >= curr) {
                result.append(romanMap.get(curr));
                num -= curr;
            } else {
                curr = keys[index++];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Q12_IntegerToRoman solution = new Q12_IntegerToRoman();
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(3999));
    }
}
