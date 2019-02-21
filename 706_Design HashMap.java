The general implementation of HashMap uses bucket which is basically a chain of linked lists and each node containing <key, value> pair.
**********************************************************************************************
public class HashMap{
    class ListNode {
        int key, val; // define key and value
        ListNode next;
        
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index); // find first element in the bucket
        return prev.next == null ? -1 : prev.next.val;
    }
    public void put(int key, int value) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);
		
		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else 
			prev.next.val = value;
	}

	public void remove(int key){
		int index = getIndex(key);
        ListNode prev = findElement(index, key);
			
        if(prev.next != null)
		    prev.next = prev.next.next;
	}
	
    ListNode nodes = new ListNode[10000];
    // calculate hashcode of the key get the bucket index
    public int getIndex(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    // if multiple key in one bucket, find it
    public ListNode findElement(int key, int index){
        if (nodes[index] == null)
            return nodes[index] = new ListNode(-1, -1);
        ListNode prev = nodes[index]; // find first element
        
        while (prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    } 
}
