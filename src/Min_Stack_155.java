import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class Min_Stack_155 {
    private PriorityQueue<Integer> mins;
    private int index;
    private int[] values;
    private int n;
    /** initialize your data structure here. */
    public Min_Stack_155() {
        mins = new PriorityQueue<>();
        index = 0;
        n = 256;
        values = new int[n];
    }

    public void push(int x) {
        if(index >= n){
            n <<= 1;
            if(n < 0)
                n = Integer.MAX_VALUE;
            values = Arrays.copyOf(values,n);
        }
        values[index++] = x;
        mins.add(x);
    }

    public void pop() {
        mins.remove(values[--index]);
    }

    public int top() {
        return values[index-1];
    }

    public int getMin() {
        return mins.peek();
    }
}
