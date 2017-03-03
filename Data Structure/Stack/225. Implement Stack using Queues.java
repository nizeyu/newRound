//My Solution
public class MyStack {
    Queue<Integer> temp = new LinkedList<>();
    Queue<Integer> stack = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(empty())
            stack.offer(x);
        else {
            while(!stack.isEmpty())
                temp.offer(stack.poll());
            stack.offer(x);
            while(!temp.isEmpty())
                stack.offer(temp.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return stack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
