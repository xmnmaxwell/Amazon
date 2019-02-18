class MyQueue {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    private void stack2ToStack1(Stack stack1, Stack stack2){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());//第二个栈先判断第一个栈是不是非空，再把元素一一添加进第二个栈
        }
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
         stack2.push(x);//第一个栈正常放入数
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.isEmpty())
        this.stack2ToStack1(stack1, stack2);
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack1.isEmpty())
        this.stack2ToStack1(stack1, stack2);
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.isEmpty())
        this.stack2ToStack1(stack1, stack2);
        return stack1.isEmpty();
    }
}
