O(1) for each operation, O(n) space. For popMax, it is O(n) time compelxity
class MinStack {
    //思想就是建两个栈，一个是正常的操作，另一个是存放实时的最小值
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
****************************************************************************
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()){
            maxStack.push(x);   
        }
        else {
            maxStack.push(Math.max(x, maxStack.peek()));
        }
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek(); // we get the max value
        Stack<Integer> temp = new Stack(); // create new stack to 
        while (top() != max) temp.push(pop()); // while top is not max, we put the element in the temp stack
        pop();
        while (!temp.isEmpty()) push(temp.pop()); // put the element from temp to current stack
        return max; // return max
    }
}
