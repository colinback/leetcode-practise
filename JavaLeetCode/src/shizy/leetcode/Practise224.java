package shizy.leetcode;

import java.util.Deque;
import java.util.ArrayDeque;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 * non-negative integers and empty spaces
 * 
 * Example 1:
 * Input: "1 + 1"
 * Output: 2
 * 
 * Example 2:
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */

public class Practise224 {
    public static void main(String[] args) {
        Practise224 p = new Practise224();

        // System.out.println(p.calculate("1 + 1"));
        // System.out.println(p.calculate("2-1 + 2"));
        System.out.println(p.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    private int eval(int a, int b, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            default:
                break;
        }

        return res;
    }

    public int calculate(String s) {
        // stacks
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        // reverse string
        s = new StringBuffer(s).reverse().toString();
        System.out.println(s);

        int loc = 0;
        while (loc < s.length()) {
            char ch = s.charAt(loc);

            if (ch == ' ') {
                loc++;
            } else if (ch == '+' || ch == '-' || ch == ')') {
                ops.push(ch);
                loc++;
            } else if (ch == '(') {
                while (ops.peek() != ')') {
                    int a = operands.pop();
                    int b = operands.pop();
                    char op = ops.pop();

                    operands.push(eval(a, b, op));
                }
                // pop char ')'
                ops.pop();
                loc++;
            } else {
                // non-negative integers
                StringBuffer sb = new StringBuffer();
                while (loc < s.length() && Character.isDigit(s.charAt(loc)))
                    sb.append(s.charAt(loc++));

                int number = Integer.valueOf(sb.reverse().toString());
                operands.push(number);
            }
        }

        while (!ops.isEmpty()) {
            char op = ops.pop();
            int a = operands.pop();
            int b = operands.pop();

            operands.push(eval(a, b, op));
        }

        return operands.pop();
    }
}