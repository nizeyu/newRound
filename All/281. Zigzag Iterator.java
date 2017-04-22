//Method: iterator
public class ZigzagIterator {
    Queue<Iterator> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<Iterator>();
        
        if(!v1.isEmpty())
            q.add(v1.iterator());
            
        if(!v2.isEmpty())
            q.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> i = q.poll();
        int res = i.next();
        if(i.hasNext())
            q.offer(i);
        return res;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
 //My Solution
 public class ZigzagIterator {
    Queue<Integer> q = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int i = 0;
        int j = 0;
        while(i < v1.size() && j < v2.size()) {
            q.offer(v1.get(i));
            q.offer(v2.get(j));
            i++;
            j++;
        }
        
        while(i < v1.size()) {
            q.offer(v1.get(i));
            i++;
        }
        
        while(j < v2.size()) {
            q.offer(v2.get(j));
            j++;
        }
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
