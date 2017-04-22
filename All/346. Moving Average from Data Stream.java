//My Solution: 傻
public class MovingAverage {
    List<Integer> list = new ArrayList<>();
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size; 
    }
    
    public double next(int val) {
        double sum = 0;
        if(list.size() < size) {
            list.add(val);
            for(int i = 0; i < list.size(); i++)
                sum += list.get(i);
            return sum / list.size();
        } else {
            list.add(val);
            for(int i = list.size() - size; i < list.size(); i++)
                sum += list.get(i);
            return sum / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 
 //Queue
 public class MovingAverage {
    Queue<Integer> q;
    int size;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(q.size() == size)
            sum -= q.poll();
        
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
