package cn.stanliski.offer51.DFS;

/**
 * 
 * Word Search.
 * 
 * @author Stanley
 *
 */
public class WordSearch {

	private static ThreadLocal connectionHolder = new ThreadLocal(){};
	
	/**
	 * Exist
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word){		
		if(word.length() == 0)
			return true;
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0; i < visited.length; i++){
			for(int j = 0; j < visited[0].length; j++){
				visited[i][j] = false;
			}
		}
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == word.charAt(0)){
					visited[i][j] = true;
					if(word.length() == 1 || dfs(board, word.substring(1), i, j, visited))
						return true;
					visited[i][j] = false;
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * DFS check
	 * @param board
	 * @param word
	 * @param x
	 * @param y
	 * @param visited
	 * @return
	 */
	public boolean dfs(char[][] board, String word, int x, int y, boolean[][] visited){
		if(word.length() == 0)
			return true;
		int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		for(int k = 0; k < directions.length; k++){
			int nextX = x + directions[k][0];
			int nextY = y + directions[k][1];
			if(nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length
					&& visited[nextX][nextY] == false && board[nextX][nextY] == word.charAt(0)){
				visited[nextX][nextY] = true;
				if(word.length() == 1 || dfs(board, word.substring(1), nextX, nextY, visited)){
					return true;
				}
				visited[nextX][nextY] = false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		WordSearch wordSearch = new WordSearch();
		char[][] board = new char[][]{"ABCE".toCharArray(),"SFCS".toCharArray(),"ADEE".toCharArray()};
		String word = "ABCCED";
		System.out.println(wordSearch.exist(board, word));
	}
	
}
