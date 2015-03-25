package cn.stanliski.offer51.DFS;

import java.awt.List;
import java.util.LinkedList;

/**
 * Find Maze
 * @author huangs14
 *
 */
public class Maze {

	/**
	 * Find Path.
	 * @param board
	 * @param start
	 * @param end
	 */
	public void findPath(int[][] board, Point start, Point end){
		if(board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		int[][] visited = new int[m][n];
		LinkedList<Point> result = new LinkedList<Point>();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(i == start.x && j == start.y){
					visited[i][j] = 1;
					result.add(new Point(i,j));
					dfs(board, i, j, end, visited, result);
					visited[i][j] = 0;
					result.removeLast();
				}
			}
		}
	}

	public void dfs(int[][] board, int x, int y, Point end, int[][] visited, LinkedList<Point> list){
		if(x == end.x && y == end.y){
			if(list.size() >= 0){
				System.out.println("Find path.");
				for(int i = 0; i < list.size(); i++){
					Point p = list.get(i);
					System.out.print("(" + p.x + "," + p.y + ") ");
				}
			}
		}
		int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		for(int i = 0; i < directions.length; i++){
			int nextX = x + directions[i][0];
			int nextY = y + directions[i][1];
			if(nextX >= 0 && nextX < board.length 
					&& nextY >= 0 && nextY < board[0].length 
					&& visited[nextX][nextY] == 0 && board[nextX][nextY] == 0){
				visited[nextX][nextY] = 1;
				list.add(new Point(nextX, nextY));
				dfs(board, nextX, nextY, end, visited, list);
				visited[nextX][nextY] = 0;
				list.removeLast();
			}
		}

	}
	
	public static void main(String args[]){
		int[][] board = new int[][]{{1,1,1,0},{0,0,1,0},{1,0,1,0},{1,0,0,0}};
		Point start = new Point(1,0);
		Point end = new Point(2,3);
		Maze maze = new Maze();
		maze.findPath(board, start, end);
	}

}
