//My Solution
public class MyQueue {
    Stack<Integer> temp = new Stack<>();
    Stack<Integer> q = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(empty())
            q.push(x);
        else {
            while(!empty())
                temp.push(q.pop());
            q.push(x);
        }
        while(!temp.isEmpty())
            q.push(temp.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty())
            return q.pop();
        else
            throw new IllegalArgumentException("Empty queue");
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty())
            return q.peek();
        else
            throw new IllegalArgumentException("Empty queue");
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
