Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
O(1) time + O(maxsize)
**********************************************************
public class MovingAverage {
private double previousSum = 0.0;
private int maxSize; // size we set for the window
private Queue<Integer> currentWindow;
// initialize the varaibles
public MovingAverage(int size) {
    currentWindow = new LinkedList<Integer>();
    maxSize = size;
}

public double next(int val) {
    if (currentWindow.size() == maxSize) // first check if currentwindow size is equal to maxSize
    {
        previousSum -= currentWindow.remove(); //remove element in the queue 
    }
    
    previousSum += val; // add new val to the sum
    currentWindow.add(val); // add new elment in the queue
    return previousSum / currentWindow.size(); // return average
}}
