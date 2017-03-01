//My Solution: two stack
public class MinStack {
    Stack<Integer> valStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        valStack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }
    
    public void pop() {
        valStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
