package com.it.blue;

import java.util.Arrays;

//求最长公共子序列--动态规划
//需要使用矩阵的数据结构
/*
 * a[i,j]=0-->i=0,j=0;
 * 		  a[i-1,j-1]+1--->a[i]=a[j]
 * 		  max(a[i-1,j],a[i,j-1])-->a[i]!=a[j]
 */
public class Blue_78 {
	private static int[][] arr;
	public static int strMax(int[][] art,String a,String b){
		int max = 0;
		for(int i = 0;i<art.length;i++){
			int j = 0;
			for(;j<art[i].length;j++){
				if(i==0&&j==0){
					art[i][j]=0;
				}
				if(a.charAt(i)==b.charAt(j)){
					if(i-1<0||j-1<0){
						art[i][j] = 1;
					}else{
						art[i][j] = art[i-1][j-1]+1;
					}
				}
				max = Math.max(max, art[i][j]);
				/*if(a.charAt(i)!=b.charAt(j)){
					if(i-1<0||j-1<0)continue;
					art[i][j] = Math.max(art[i-1][j], art[i][j-1]);
				}*/
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String a = "banana";
		String b = "cianaic";
		arr = new int[a.length()][b.length()];
		System.out.println(strMax(arr, a, b)+"*****");
		for(int i = 0;i<arr.length;i++){
			System.out.print(Arrays.toString(arr[i]));
			System.out.println();
		}
	}
}
