import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by marvin on 16/8/25.
 *
 * Question:
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Evaluate_Reverse_Polish_Notation {
    // 数字可以是负的
    interface Operator{
        int operate(int x, int y);
    }

    HashMap<String, Operator> opSet =
            new HashMap<String, Operator>() { {
                put("+", new Operator() {
                    @Override
                    public int operate(int x, int y) {
                        return y + x;
                    }
                });
                put("-", new Operator() {
                    @Override
                    public int operate(int x, int y) {
                        return y - x;
                    }
                });
                put("*", new Operator() {
                    @Override
                    public int operate(int x, int y) {
                        return y * x;
                    }
                });
                put("/", new Operator() {
                    @Override
                    public int operate(int x, int y) {
                        return y / x;
                    }
                });
            }
            };
    public int evalRPN(String[] tokens) {
        Stack<Integer> intStack = new Stack<Integer>();
        for (String s : tokens) {
            if (opSet.containsKey(s)) {
                intStack.push(opSet.get(s).operate(intStack.pop(), intStack.pop()));
            } else {
                // 解析函数
                intStack.push(Integer.parseInt(s));
            }
        }
        return intStack.pop();
    }

//    public int evalRPN(String[] tokens) {
//        Stack<Integer> intStack = new Stack<Integer>();
//        for (int i = 0; i < tokens.length; i++) {
//            String s = tokens[i];
//            char op = s.charAt(0);
//            int op1, op2;
//
//            if (s.length() == 1) {
//                if (op == '+') {
//                    op1 = intStack.pop();
//                    op2 = intStack.pop();
//                    intStack.push(op2 + op1);
//                } else if (op == '-') {
//                    op1 = intStack.pop();
//                    op2 = intStack.pop();
//                    intStack.push(op2 - op1);
//                } else if (op == '*') {
//                    op1 = intStack.pop();
//                    op2 = intStack.pop();
//                    intStack.push(op2 * op1);
//                } else if (op == '/') {
//                    op1 = intStack.pop();
//                    op2 = intStack.pop();
//                    intStack.push(op2 / op1);
//                } else {
//                    intStack.push(op-'0');
//                }
//            } else {
//                intStack.push(isNumber(s));
//            }
//        }
//        return intStack.pop();
//    }
//
//    private int isNumber(String s) {
//        int index = 0;
//        boolean positive = true;
//        if (s.charAt(0) == '-') {
//            positive = false;
//            index = 1;
//        }
//
//        int num = 0;
//        for (; index < s.length(); index++) {
//            num *= 10;
//            num += (s.charAt(index)-'0');
//        }
//        return positive == true ? num : -num;
//    }
}
