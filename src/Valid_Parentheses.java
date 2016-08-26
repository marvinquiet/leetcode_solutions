import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by wjma on 8/26/16.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> parMap = new HashMap<>();
        parMap.put(')', '(');
        parMap.put(']', '[');
        parMap.put('}', '{');

        Stack<Character> charStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char par = s.charAt(i);
            if (parMap.containsKey(par)) {
                // isEmpty() 判断如果进来就是右孩子的情况
                if (charStack.isEmpty() || !charStack.pop().equals(parMap.get(par)))
                    return false;
            } else
                charStack.push(par);
        }

        return charStack.isEmpty();
    }
}
