package com.it.blue;

import java.util.ArrayList;

//对ip地址的划分
//25525511123
/*
 * 拿到一个问题之后，首先要分析
 * 字符串的长度是已知的；
 * ip地址每一位的范围是0~255；
 * 
 */
public class Blue_59 {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> set = new ArrayList<String>();
        ArrayList<String> arr = new ArrayList<String>();
		dfs(0,set,arr,s);
		return set;
    }
	
	public void dfs(int start,ArrayList<String> set,ArrayList<String> arr,String s) {
		if(start==s.length()&&arr.size()==4){
			set.add(arr.get(0)+"."+arr.get(1)+"."+arr.get(2)+"."+arr.get(3));
			return;
		}
		if(s.length()-start>3*(4-arr.size())){
			return;
		}
		if(s.length()-start<(4-arr.size())){
			return;
		}
       for(int i = start;i<start+3&&i<s.length();i++){
    	   int num = Integer.parseInt(s.substring(start,i+1));
    	   if(num<0||num>255){
    		   continue;
    	   }
    	   arr.add(s.substring(start,i+1));
    	   dfs(i+1,set,arr,s);
    	   arr.remove(arr.size()-1);
    	   if(num==0){
    		   break;
    	   }
       }
    }
	public static void main(String[] args) {
		String s = "25525511123";
		ArrayList<String> ip = new Blue_59().restoreIpAddresses(s);
		for(String i : ip){
			System.out.println(i);
		}
		
	}
}
