package cn.stanliski.offer51.bitmap;

/**
 * 
 * BitMapSort
 * 
 * @author stanley_hwang
 *
 */
public class BitMapSort {

	public static void main(String[] args) {  
		int nums[]={15,1,55,6,22,48,3,2,51};  
		sort(nums);  
		for(int i=0;i<nums.length;i++){  
			System.out.print("<"+nums[i]);  
		}  
	}  

	//数组元素必须是无重复的整数  
	public static void sort(int array[])//排序算法  
	{  
		int max=55;//要排序的数字最大值55  
		byte[] temp =new byte[max];//生成55个元素的byte数组  
		for(int i=0;i<array.length;i++)  
		{  
			temp[array[i]]=1; //若索引在要排序的数组中就把byte数组值标记为1；否则为0；  
		}  

		for(int j=0,k=0;k<max;k++)  
		{  
			if(temp[k]==1)//看看byte数组中是否为1；  
			{  
				array[j++]=k;//若为1则将索引值写入原数组，就排好了  
			}  
		}  
	}  


}
