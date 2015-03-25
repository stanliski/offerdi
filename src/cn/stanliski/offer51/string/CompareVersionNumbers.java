package cn.stanliski.offer51.string;

/**
 * 
 * Compare Version Numbers.
 * 
 * @author stanley_hwang
 *
 */
public class CompareVersionNumbers {

	/**
	 * The right and effective method to solve the problem.
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersionRight(String version1, String version2) {  
		if(version1 == null || version2 ==null) 
			return 0;  
		String[] v1 = version1.split("\\.");  
		String[] v2 = version2.split("\\.");  
		int len1 = v1.length;  
		int len2 = v2.length;  
		int i=0;  
		while(i < len1 || i < len2) {  
			int x1 = i < len1 ? Integer.parseInt(v1[i]) : 0;  
			int x2 = i < len2 ? Integer.parseInt(v2[i]) : 0;  
			if(x1 > x2) return 1;  
			else if(x1 < x2) return -1;  
			else ++i;  
		}  
		return 0;  
	}  
	
	public int compareVersionType(String version1, String version2){
		if(version1 == null || version2 == null)
			return 0;
		String[] array1 = version1.split("\\.");
		String[] array2 = version2.split("\\.");
		int len1 = array1.length;
		int len2 = array2.length;
		int i = 0;
		while(i < len1 || i < len2){
			int num1 = i < len1 ? Integer.parseInt(array1[i]) : 0;
			int num2 = i < len2 ? Integer.parseInt(array2[i]) : 0;
			if(num1 > num2)
				return 1;
			else if(num1 < num2)
				return -1;
			else 
				++i;
		}
		return 0;
	}
	

	/**
	 * Compare versions.
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		if(version1 == null){
			String[] str = version2.split("\\.");
			for(int i = 0; i < str.length; i++){
				if(!str[i].equals("0"))
					return -1;
			}
			return 0;
		}
		if(version2 == null){
			String[] str = version1.split("\\.");
			for(int i = 0; i < str.length; i++){
				if(!str[i].equals("0"))
					return 1;
			}
			return 0;
		}
		if(!version1.contains(".") && !version2.contains(".")){
			return compareStr(version1, version2);
		}
		if(version1.contains(".") && version2.contains(".")){
			String num1 = version1.substring(0, version1.indexOf('.'));
			String num2 = version2.substring(0, version2.indexOf('.'));
			int result = 0;
			if((result = compareStr(num1, num2)) == 0)
				return compareVersion(version1.substring(version1.indexOf('.')+1), version2.substring(version2.indexOf('.')+1));
			else
				return result;
		}
		if(version1.contains(".") || version2.contains(".")){
			int result = 0;
			if(version2.contains(".")){
				if((result=compareStr(version1, version2.split("\\.")[0])) == 0){
					return compareVersion(null, version2.substring(version2.indexOf('.')+1));
				}else
					return result;
			}else{
				if((result=compareStr(version1.split("\\.")[0], version2)) == 0){
					return compareVersion(version1.substring(version1.indexOf('.')+1), null);
				}else
					return result;
			}
		}
		return 0;
	}

	public int compareStr(String str1, String str2){
		int num1 = Integer.valueOf(str1);
		int num2 = Integer.valueOf(str2);
		if(num1 > num2)
			return 1;
		else if(num1 < num2)
			return -1;
		else
			return 0;
	}

	public static void main(String args[]){
		CompareVersionNumbers numbers = new CompareVersionNumbers();
		int result = numbers.compareVersion("1.0", "1");

		System.out.println(result);
	}

}
