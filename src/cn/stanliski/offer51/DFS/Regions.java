package cn.stanliski.offer51.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Regions {

	class Point{

		public int x;

		public int y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

	}

	public void printMatrix(char[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve(char[][] board) {
		Queue<Point> queue = new LinkedList<Point>();
		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O' && !visited[i][j]) {
					boolean surounned = true;
					List<Point> visitedPoints = new ArrayList<Point>();
					queue.add(new Point(i,j));
					visited[i][j] = true;
					while (queue.size() > 0) {
						Point point = queue.poll();
						visitedPoints.add(point);
						for (int k = 0; k < dir.length; k++) {
							int nextx = point.x + dir[k][0];
							int nexty = point.y + dir[k][1];
							if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
								if (board[nextx][nexty] == 'O' && !visited[nextx][nexty])
									queue.add(new Point(nextx,nexty));
								visited[nextx][nexty] = true;
							} else {
								surounned = false;
							}
						}
					}
					if(surounned) {
						for(Point p : visitedPoints)
							board[p.x][p.y] = 'X';
					}
				}
			}
		}
	}

	public static void main(String args[]){
		Regions regions = new Regions();
	}
}
