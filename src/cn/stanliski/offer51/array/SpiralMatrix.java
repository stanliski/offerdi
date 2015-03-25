package cn.stanliski.offer51.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Spiral Matrix 
 * 
 * @author stanley_hwang
 *
 */
public class SpiralMatrix {


	public List<Integer> spiralOrder9th2(int[][] matrix){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0)
			return rst;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		while(count*2 < rows && count*2 < cols){

			for(int i = count; i < cols-count; i++)
				rst.add(matrix[count][i]);

			for(int i = count+1; i < rows-count; i++)
				rst.add(matrix[i][cols-count-1]);

			if(rows-2*count == 1 || cols-2*count == 1)
				break;

			for(int i = cols-count-2; i>=count; i--)
				rst.add(matrix[rows-count-1][i]);

			for(int i = rows-count-2; i>=count+1; i--)
				rst.add(matrix[i][count]);

		}
		return rst;
	}

	public List<Integer> spiralOrder9th(int[][] matrix){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0) 
			return rst;

		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		while(count * 2 < rows && count * 2 < cols){
			for(int i = count; i < cols-count; i++)
				rst.add(matrix[count][i]);

			for(int i = count+1; i< rows-count; i++)
				rst.add(matrix[i][cols-count-1]);

			if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
				break;

			for(int i = cols-count-2; i>=count; i--)
				rst.add(matrix[rows-count-1][i]);

			for(int i = rows-count-2; i>= count+1; i--)
				rst.add(matrix[i][count]);

			count++;
		}
		return rst;
	}

	/**
	 * Spiral Order.
	 * 
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return new ArrayList<Integer>(0);
		int start = 0;
		int rows = matrix.length;
		int columns = matrix[0].length;
		List<Integer> result = new ArrayList<Integer>(rows * columns);
		while(columns > start*2 && rows > start*2){
			printMatrixInCircle(matrix, columns, rows, start, result);
			++start;
		}
		return result;
	}

	/**
	 * Print matrix in circle.
	 * @param matrix
	 * @param columns
	 * @param rows
	 * @param start
	 */
	public void printMatrixInCircle(int[][] matrix, int columns, int rows, int start, List<Integer> results){
		int endX = columns-1-start;
		int endY = rows-1-start;
		for(int i=start; i<=endX; i++){
			int number = matrix[start][i];
			results.add(number);
		}
		if(start < endY){
			for(int i=start+1;i<=endY;++i){
				int number = matrix[i][endX];
				results.add(number);
			}
		}
		if(start < endX && start < endY){
			for(int i=endX-1; i>=start; --i){
				int number = matrix[endY][i];
				results.add(number);
			}
		}
		if(start<endX && start<endY-1){
			for(int i=endY-1;i>=start+1;--i){
				int number = matrix[i][start];
				results.add(number);
			}
		}
	}

	public static void main(String args[]){
		int[][] board = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		SpiralMatrix matrix = new SpiralMatrix();
		List<Integer> list = matrix.spiralOrder(board);
		for(Integer i : list){
			System.out.print(i + " ");
		}
	}

}
