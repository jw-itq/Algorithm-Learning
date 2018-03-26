package com.it.blue;

import java.util.ArrayList;
//ÉîËÑÈ«ÅÅÁĞ
public class Blue_60 {
	private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> quan(String s){
		int[] mo = new int[s.length()];
		char[] str = new char[s.length()];
		char[] re = s.toCharArray();
		return quan2(0, str, mo, re);
	}
	public ArrayList<ArrayList<String>> quan2(int n,char[] str,int[] mo,char[] re){
		if(n==mo.length){
			ArrayList<String> arr = new ArrayList<String>();
			for(char i : str){
				arr.add(i+"");
			}
			list.add(arr);
		}else{
			for(int i = 0;i<mo.length;i++){
				if(mo[i]==0){
					mo[i]=1;
					str[n]=re[i];
					quan2(n+1, str, mo, re);
					mo[i]=0;
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		String s = "abc";
		ArrayList<ArrayList<String>> li = new Blue_60().quan(s);
		for(ArrayList<String> t : li){
			for(String i: t){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
