package leetcodeLocal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <Description>
 * LinkedList 的API
 * add() 将元素加到末尾
 * offer()
 * addFirst()
 * addLast()
 * peek()检索但是不删除列表的第一个元素
 * push() pop() 可以当成栈来用
 *
 * <br>
 *
 * @author sunyue <br>
 */
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.min();
        minStack.pop();
        minStack.min();

    }

    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int min() {
        return minStack.peek();
    }
}
