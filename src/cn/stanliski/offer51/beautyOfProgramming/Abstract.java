package cn.stanliski.offer51.beautyOfProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 包含所有关键字（关键字不要求按用户输入的顺序排列）的长度最短的摘要
 * 
 * @author stanley_hwang
 *
 */
public class Abstract {
	
	/*
	 * 编程之美 最短摘要生成
	 * */

	private int[] keywordsArray; //记录关键字被访问次数的数组
	private int pBegin=0;//查找起始点
	private int pEnd=0;//查找终点
	private int abstractBegin=0;//摘要起始点
	private int abstractEnd=0;//摘要终点
	private int targetLen;//摘要最小长度
	private Map<String,Integer> map;//将关键字映射成数字

	public Abstract(String[] keywords){
		int len = keywords.length;
		this.keywordsArray = new int[len];
		this.map = keywordsMap(keywords);
	}
	public String extractSummary(String[] description,String[] keywords){
		return extract(description,keywords);
	}
	
	//实际的抽取函数
	public String extract(String[] description,String[] keywords){
		String summary = "";
		int nLen = description.length;
		targetLen = nLen+1;
		while(true){
			while(!isAllExisted() && pEnd < nLen){
				if(this.map.get(description[pEnd]) != null){
					setKeywordsArray(keywordsArray,this.map.get(description[pEnd]),0);
				}
				pEnd++;
			}
			
			while(isAllExisted()){
				if(pEnd-pBegin < targetLen){
					targetLen = pEnd-pBegin;
					abstractBegin = pBegin;
					abstractEnd = pEnd-1;
				}
				if(map.get(description[pBegin])!=null){
					setKeywordsArray(keywordsArray,map.get(description[pBegin]),1);
				}
				pBegin++;
			}
			if(pEnd>=nLen){
				break;
			}
		}
		for(int j=abstractBegin;j<=abstractEnd;j++){
			if(j != abstractEnd){
				summary = summary + description[j] + " ";
			}else{
				summary += description[j];
			}    
		}
		return summary;
	}
	
	public Map<String,Integer> keywordsMap(String[] keywords){
		Map<String,Integer> map = new HashMap<String,Integer>();
		int len = keywords.length;
		for(int i=0;i<len;i++){
			map.put(keywords[i], i);
		}
		return map;
	}
	
	//设置关键字被访问到的次数
	public void setKeywordsArray(int[] keywordsArray,int i,int flag){ //flag:0 add flag:1 sub
		if(flag==0){
			keywordsArray[i]++;
		}else{
			keywordsArray[i]--;
		}
	}
	
	//检查是否包含全部关键字
	public boolean isAllExisted(){
		boolean result = true;
		for(int a : keywordsArray){
			if(a == 0){
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String description[] = new String[]{"微软","亚洲","研究院","成立","于","1998","年","，","我们","的","使命",
			    "是","使","未来","的","计算机","能够","看","、","听","、","学","，",
			    "能","用","自然语言","与","人类","进行","交流","。","在","此","基础","上",
			    "，","微软","亚洲","研究院","还","将","促进","计算机","在","亚太","地区",
			    "的","普及","，","改善","亚太","用户","的","计算","体验","。","”"};
		String[] keywords = {"微软", "计算机", "亚洲"};
		Abstract nAbstract = new Abstract(keywords);
		System.out.println(nAbstract.extractSummary(description, keywords));
	}
}
