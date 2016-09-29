import java.util.HashMap;
import java.util.Stack;

/**
 * Created by wjma on 7/19/16.
 */
public class Main {

    public static void main(String[] args) {
        printStack(processString("AAABCCDDDCB"));
        printStack(processString("AABBBABBBA"));
        printStack(processString(""));
        printStack(processString("ABCBBBCBBBCBBAA"));

    }

    private static Stack<Character> processString(String str) {
        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> countStack = new Stack<Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charStack.isEmpty()) {
                charStack.push(c);
                countStack.push(1);
            } else {
                // eliminate
                if (charStack.peek() == c && countStack.peek() == 2) {
                    charStack.pop();
                    charStack.pop();
                    countStack.pop();
                    countStack.pop();
                } else if (charStack.peek() == c && countStack.peek() == 1) {
                    charStack.push(c);
                    countStack.push(2);
                } else if (charStack.peek() != c) {
                    charStack.push(c);
                    countStack.push(1);
                }
            }
        }

        return charStack;
    }

    private static void printStack(Stack<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!characters.isEmpty()) {
            stringBuilder.append(characters.pop());
        }
        // stack is reverse version of string
        stringBuilder = stringBuilder.reverse();
        for (int i = 0; i < stringBuilder.length(); i++) {
            System.out.print(stringBuilder.charAt(i));
        }
        System.out.println();
    }
}
