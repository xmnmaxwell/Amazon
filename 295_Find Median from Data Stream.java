//O(logn) O(n)
class MedianFinder {    
    PriorityQueue<Integer> lo = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<Integer>();

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());        
        if(hi.size() > lo.size())lo.add(hi.poll());
    }
    
    public double findMedian() {
        return lo.size() > hi.size() ? (double)lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}
