
**********************************************************
class MovingAverage {
    Queue<Integer> q;
    int size;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        if (q.size() < size) {
            q.offer(val);
            int n = q.size();
            while (!q.isEmpty()){
                sum += q.poll();
            }
            return (double) (sum)/ (double) (n);
        } else {
            q.poll();
            q.offer(val);
            while (!q.isEmpty()){
                sum += q.poll();
            }
            return (double) (sum)/ (double) (size);
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
