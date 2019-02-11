class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return new int[0][0];
        }
        Queue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] p, int[] q) {
                return (int)(Math.pow(q[0], 2) + Math.pow(q[1], 2) - (Math.pow(p[0], 2) + Math.pow(p[1], 2)));
            }
        });
        int[][] ans = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        for (int i = 0; i < K; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
