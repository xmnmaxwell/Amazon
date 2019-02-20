
*******************************************************************
//add O(logn) find O(1)
class MedianFinder {    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.offer(num);   //each element is added to minHeap
        maxHeap.offer(minHeap.poll());  // then the minimum element is poped out and put in maxHeap, assure minHeap is greater than maxHeap      
        if(maxHeap.size() > minHeap.size()) 
            minHeap.offer(maxHeap.poll()); // two heaps need to be loaded balanced
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
