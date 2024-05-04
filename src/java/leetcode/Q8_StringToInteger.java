package leetcode;

public class Q8_StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();

        if (str.charAt(0) != '-' && str.charAt(0) != '+' && !Character.isDigit(str.charAt(0))) {
            return 0;
        }

        boolean isMinus = false;
        int result = 0;
        if (str.charAt(0) == '-') {
            isMinus = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }

            int num = str.charAt(i) - '0';

            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < num) {
                if (isMinus) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }

            result = result * 10 + num;
        }

        return result * (isMinus ? -1 : 1);
    }

    public static void main(String[] args) {
        Q8_StringToInteger sti = new Q8_StringToInteger();

        System.out.println(sti.myAtoi("42"));
        System.out.println(sti.myAtoi("    -42"));
        System.out.println(sti.myAtoi("4193 with words"));
        System.out.println(sti.myAtoi("words and 987"));
        System.out.println(sti.myAtoi("-91283472332"));
        System.out.println(sti.myAtoi("-2147482648"));
        System.out.println(sti.myAtoi("--2147482648"));
        System.out.println(sti.myAtoi("+2147482648"));
        System.out.println(sti.myAtoi("++2147482648"));
    }
}
