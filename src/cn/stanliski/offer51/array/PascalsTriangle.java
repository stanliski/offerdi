package cn.stanliski.offer51.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Pascal's Triangle.
 * 
 * @author stanley_hwang
 *
 */
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows == 0)
			return result;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		result.add(list);
		dfs(result, list, numRows, 1);
		return result;
	}

	/**
	 * Question II.
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(1);
		if(rowIndex < 2){
			for(int i = 0; i < rowIndex; i++){
				result.add(1);
			}
		}else{
			int ocurTimes = 1;
			int runtimes = rowIndex - 1;
			while(!queue.isEmpty()){
				int data = queue.poll();
				if(data == 1 && ocurTimes == 0){
					queue.add(data);
					ocurTimes = 1;
					runtimes--;
					if(runtimes == 0)
						break;
				}else{					
					int newData = data + queue.peek();
					if(data == 1){
						queue.add(data);
						ocurTimes--;
					}
					queue.add(newData);
				}
			}
		}
		while(!queue.isEmpty()){
			result.add(queue.poll());
		}
		return result;
	}

	/**
	 * More difficult.
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generateII(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows == 0)
			return result;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		result.add(list);
		dfs(result, list, numRows, 1);
		return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> list, int numRows, int num){
		if(numRows == num)
			return;
		List<Integer> sublist = new ArrayList<Integer>(2);
		if(result.size() == 1){
			sublist.add(1);
			sublist.add(1);
			result.add(sublist);
		}else{
			for(int i = 0; i < list.size(); i++){
				if(i == 0)
					sublist.add(list.get(0));
				else{
					sublist.add((list.get(i-1) + list.get(i)));
				}
			}
			sublist.add(1);
			result.add(sublist);
		}
		dfs(result, sublist, numRows, ++num);
	}

	public void printList(List<List<Integer>> result){
		for(int i = 0; i < result.size(); i++){
			List<Integer> list = result.get(i);
			for(int j = 0; j < list.size(); j++){
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]){
		int num = 6;
		PascalsTriangle triangle = new PascalsTriangle();
		List<List<Integer>> result = triangle.generate(num);
		//		triangle.printList(result);
		List<Integer> list = triangle.getRow(3);
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
	}

}
