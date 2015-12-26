/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
public class _155_MinStack {
    
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        if (x < min)
            min = x;
        minStack.push(min);
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.size() > 0 ? minStack.peek() : Integer.MAX_VALUE;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    } 
}