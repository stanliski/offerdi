package cn.stanliski.offer51.DFS;

import java.util.LinkedList;
import java.util.List;

public class MRegion{

	/**
	*	Solve
	*/
	public void solve(char[][] board, Point start, Point end){
		if(board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		int[][] visited = new int[m][n];
		LinkedList<Point> visitedPath = new LinkedList<Point>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == start.x && j == start.y){
					visited[i][j] = 1;
					visitedPath.add(new Point(i, j));
					dfs(board, end, i, j, visited, visitedPath);
					visited[i][j] = 0;
					visitedPath.removeLast();
 				}		
			}
		}
	}

	/**
	* 
	* DFS
	* 
	*/
	public void dfs(char[][] board, Point end, int i, int j, 
					int[][] visited, LinkedList<Point> visitedPath){
		if(i == end.x && j == end.y){
			if(visitedPath != null)
				for(int k = 0; k < visitedPath.size(); k++){
					System.out.print(visitedPath.get(k) + " ");
				}
		}
		int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		for(int k = 0; k < directions.length; k++){
			int x = i + directions[k][0];
			int y = j + directions[k][1];
			if(x >= 0 && x < board.length && y >= 0 && y < board[0].length
					&& visited[x][y] == 0 && board[x][y] == '0'){
				visited[x][y] = 1;
				visitedPath.add(new Point(x, y));
				dfs(board, end, x, y, visited, visitedPath);
				visitedPath.removeLast();
				visited[x][y] = 0;
			}
		}
	}
	
	public static void main(String args[]){
		MRegion region = new MRegion();
		char[][] board = new char[][]{"1111".toCharArray(), "0010".toCharArray(),"1010".toCharArray(), "1000".toCharArray()};
		region.solve(board, new Point(1,0), new Point(1,3));
	}

} 
