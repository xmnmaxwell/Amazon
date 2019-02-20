// queue node used in BFS
class Node{
	// (x, y) represents chess board coordinates
	// dist represent its minimum distance from the source
	int x, y, dist;
	public Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
};

class ChessKnight {
	// Below arrays details all 8 possible movements for a knight
	private int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
	private int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };

	// Check if (x, y) is valid chess board coordinates. Note that a knight cannot go out of the chessboard
	private boolean valid(int x, int y, int N) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;

		return true;
	}
	// Find minimum number of steps taken by the knight from source to reach destination using BFS
	public int BFS(Node src, Node dest, int N) {
		// map to check if matrix cell is visited before or not
		boolean[][] flag = new boolean[N][N];

		// create a queue and enqueue first node
		Queue<Node> q = new LinkedList<>();
		q.offer(src);

		// run till queue is not empty
		while (!q.isEmpty()) {
			// pop front node from queue and process it
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int dist = node.dist;

			// if destination is reached, return distance
			if (x == dest.x && y == dest.y)
				return dist;

			// Skip if location is visited before
			if (!flag[x][y]) {
				// mark current node as visited
				falg[x][y] == true;

				// check for all 8 possible movements for a knight
				// and enqueue each valid movement into the queue
				for (int i = 0; i < 8; ++i) {
					// Get the new valid position of Knight from current
					// position on chessboard and enqueue it in the
					// queue with +1 distance
					int x1 = x + row[i];
					int y1 = y + col[i];

					if (valid(x1, y1, N))
						q.offer(new Node(x1, y1, dist + 1));
				}
			}
		}
		return -1;
	}
}
