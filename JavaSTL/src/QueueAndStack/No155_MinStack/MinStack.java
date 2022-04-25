package QueueAndStack.No155_MinStack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;   //存放数据的stack
    private Stack<Integer> minStack;    //栈顶存放的是当前stack中最小的数

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
