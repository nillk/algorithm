package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2257_FormulaWeight {
    private static final byte LB = '(';
    private static final byte RB = ')';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] formula = new char[101];
        br.read(formula);

        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        while (!Character.isWhitespace(formula[index])) {
            char current = formula[index++];
            if (current == RB) {
                int tmp = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek() == LB) {
                        stack.pop();
                        break;
                    }
                    tmp += stack.pop();
                }
                stack.push(tmp);
            } else if (Character.isDigit(current)) {
                int tmp = stack.pop();
                tmp *= (current - '0');
                stack.push(tmp);
            } else {
                stack.push(getValue(current));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }

    private static int getValue(char c) {
        switch (c) {
            case 'H':
                return 1;
            case 'C':
                return 12;
            case 'O':
                return 16;
            default:
                return c;
        }
    }
}