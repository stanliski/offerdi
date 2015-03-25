package cn.stanliski.offer51.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Simplify Path
 * 
 * @author stanley_hwang
 *
 */
public class SimplifyPath {

	public static void main(String args[]){
		String str = "/a/./b///../../c/";
		SimplifyPath path = new SimplifyPath();
		String result = path.simplifyPath(str);
		System.out.println(result);
	}
	
	/**
	 * Simplify path.
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path){
		
		String result = "/";
		String[] stubs = path.split("/");
		ArrayList<String> paths = new ArrayList<String>();
		for (String s : stubs){
			if(s.equals("..")){
				if(paths.size() > 0){
					paths.remove(paths.size() - 1);
				}
			}
			else if (!s.equals(".") && !s.equals("")){
				paths.add(s);
			}
		}
		for (String s : paths){
			result += s + "/";
		}
		if (result.length() > 1)
			result = result.substring(0, result.length() - 1);
		return result;
	
	}
	
	public String simplifyPathMeII(String path){
		String result = "/";
		String[] strs = path.split("/");
		ArrayList<String> paths = new ArrayList<String>();
		for(String s : paths){
			if(s.equals("..")){
				if(paths.size() > 0)
					paths.remove(paths.size()-1);
			}else if(!s.equals(".") && !s.equals("")){
				paths.add(s);
			}
		}
		for (String s: paths)
			result += s + "/";
		if (result.length() > 1)
			result = result.substring(0, result.length() - 1);
		return result;
	}

	public String simplifyPathMe(String path) {
		int first = -1;
		int second = -1;
		Stack<String> stack = new Stack<String>();
		String result = "";
		for(int i = 0; i < path.length(); i++){
			char c = path.charAt(i);
			if(c == '/'){
				if(first == -1){
					first = i;
				}
				else if(second == -1)
					second = i;
				if(first != -1 && (second != -1 || (i+1) == path.length())){
					String word = "";
					if(path.charAt(path.length()-1) != '/' && (i+1) == path.length()){
						word = path.substring(first+1);
					}
					else{
						if(first + 1 < second)
							word = path.substring(first+1, second);
					}
					first = second;
					second = -1;
					if(!word.equals("..") && !word.equals(".")){
						if(word != null && !word.equals(""))
							stack.push(word);
					}else if(word.equals(".")){
						;
					}else if(word.equals(".."))
						if(!stack.isEmpty())
							stack.pop();

				}
			}
		}
		if(stack.isEmpty()){
			result = "/";
		}
		else{
			while(!stack.isEmpty()){
				result = "/" + stack.pop() + result; 
			}
		}
		return result;
	}

}
