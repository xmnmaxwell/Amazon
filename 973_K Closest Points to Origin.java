Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Time Complexity O(n * logK)
***************************************************************************************
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return new int[0][0];
        }
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>(){
             public int compare(int[] o1, int[] o2){
                return (int) ((Math.pow(o2[0], 2) + Math.pow(o2[1], 2)) - (Math.pow(o1[0], 2) + Math.pow(o1[1], 2))); //降序排列
            }
        });
        for (int i = 0; i < points.length; i++){
            pq.offer(points[i]);  //将点放进pq里
            if (pq.size() > K){   //大于K的扔出去
                pq.poll();
            }
        }
        for (int j = 0; j < K; j++){  //把pq里的元素放进res里
            res[j] = pq.poll();
        }
        return res;
    }
}
