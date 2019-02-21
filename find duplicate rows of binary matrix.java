        {0, 1, 0, 0, 1}
        {1, 0, 1, 1, 0}
        {0, 1, 0, 0, 1}
        {1, 1, 1, 0, 0}
return duplicate row number.
**************************************************************
public int[] duplicateRow(int[][] matrix) { 
        int m =  matrix.length;
        int n = matrix[0].length;
        int[] res = new int[2];
        HashMap<String, Integer> set = new HashMap<>(); 
        for(int i = 0; i < m; i++) 
        { 
            String s = ""; 
            for(int j = 0; j < n; j++)  
                s += String.valueOf(arr[i][j]);
            if(!set.contains(s)) { 
                map.put(s, i);
            } else {
                res[0] = map.get(s);
                res[1] = i;
            }
        }
        return res;
    } 
*******************************************************************
// A class representing a Trie node
class Trie {
	boolean isLeaf;	// set when node is a leaf node
	Trie[] children = new Trie[2];
    // Constructor
	Trie() {
		isLeaf = false;
	}
};

public class Solution {
	int count = 0;
	// Iterative function to insert array in Trie.
	public boolean insert(Trie head, int[] row) {
		// start from root node
		Trie curr = head;

		for(int i = 0; i < row.length; i++)
		{
			// create a new node if path doesn't exists
			if (curr.children[row[i]] == null) {
				curr.children[row[i]] = new Trie();
			}
			// go to next node
			curr = curr.children[row[i]];
		}
		// if row is inserted before, return false
		if (curr.isLeaf) {
			return false;
		}
		// mark leaf node and return true
		count++;
		return (curr.isLeaf = true);
	}
    public int[] DuplicateRows(int[][] matrix) { 
    	    Trie head = new Trie(); 
	    int[] res = new int[];
    /*inserting into Trie and checking for dulpicates*/
    	for (int i = 0; i < matrix.length; i++) {
        // If already exists 
        	if (!insert(head, matrix[i])) {
			res[0] = count - 1;
			res[1] = i
    		}   
    	}
    }    
}
