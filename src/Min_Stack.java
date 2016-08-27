import java.util.Stack;

/**
 * Created by marvin on 16/8/25.
 *
 *
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 􏰁 push(x) – Push element x onto stack.
 􏰁 pop() – Removes the element on top of the stack.
 􏰁 top() – Get the top element.
 􏰁 getMin() – Retrieve the minimum element in the stack.
 */
public class Min_Stack {
    class MinStack {
        /** initialize your data structure here. */
        // minStack: if next element >= curMin, then pop; if  == , then pop it from minStack;
        // minStack 已经相当于暂存了当前最小值
        Stack<Integer> originalStack;
        Stack<Integer> minStack;
        public MinStack() {
            originalStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int x) {
            originalStack.push(x);
            // x <= minStack.peek() 以防出现 0->1->0的情况导致栈为空
            if (minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            // Integer 的比较要用equals
            if (originalStack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            if (!originalStack.isEmpty())
                return originalStack.peek();
            return Integer.MAX_VALUE;
        }

        public int getMin() {
            if (!minStack.isEmpty())
                return minStack.peek();
            return Integer.MAX_VALUE;
        }
//        Stack<Integer> minStack;
//        int curMin;
//        public MinStack() {
//            minStack = new Stack<Integer>();
//            curMin = Integer.MAX_VALUE;
//        }
//
//        public void push(int x) {
//            if (x < curMin)
//                curMin = x;
//            minStack.push(x);
//            minStack.push(curMin);
//        }
//
//        public void pop() {
//            if (!minStack.isEmpty()) {
//                minStack.pop();
//                minStack.pop();
//            }
//            if (!minStack.isEmpty())
//                curMin = minStack.peek();
//            else
//                curMin = Integer.MAX_VALUE;
//        }
//
//        public int top() {
//            if (!minStack.isEmpty()) {
//                int minTop = minStack.pop();
//                int top = minStack.peek();
//                minStack.push(minTop);
//                return top;
//            }
//            return Integer.MAX_VALUE;
//        }
//
//        public int getMin() {
//            if (!minStack.isEmpty())
//                return minStack.peek();
//            return Integer.MAX_VALUE;
//        }
    }
}
