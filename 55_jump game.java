Determine if you are able to reach the last index.
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
O(n2) + O(n)
*******************************************************
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        jump[n-1]=true;
    
        for(int i=n-2 ; i >= 0; i--){
            for(int j=0; j <= nums[i] && i+j<n; j++) {
                if(jump[i+j] == true) {
                    jump[i]=true; 
                    break;
                }
            }
        }
        return jump[0];
    }
}
********************************************************
Your goal is to reach the last index in the minimum number of jumps.
 int jump(int A[], int n) {
	 if(n<2)return 0;
	 int level=0,currentMax=0,i=0,nextMax=0;

	 while(currentMax-i+1>0){		//nodes count of current level>0
		 level++;
		 for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
			nextMax=max(nextMax,A[i]+i);
			if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level 
		 }
		 currentMax=nextMax;
	 }
	 return 0;
 }
