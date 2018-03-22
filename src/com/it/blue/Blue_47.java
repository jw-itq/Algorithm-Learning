package com.it.blue;

import java.util.Scanner;

//深搜判断一个字符串全排列
public class Blue_47 {
	static int n=1000;
	static char[] ch1 = new char[n];
	static char[] ch2 = new char[n];
	static int[] at = new int[n];
	static int len = 0;
	public static void dfs(int x){
		
		if(x==len){
			for(int i =0 ;i<len;i++){
				System.out.print(ch2[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 0;i<len;i++){
			if(at[i]==0){
				at[i]=1;
				ch2[x]=ch1[i];
				dfs(x+1);
				at[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ch1 = scan.nextLine().toCharArray();
		len = ch1.length;
		dfs(0);
	}
}
