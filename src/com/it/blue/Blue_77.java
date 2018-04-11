package com.it.blue;

public class Blue_77 {
//篮球队分组比赛，用到的算法是分治
/*
 * 思想我明白，就是不断的分治，分而治之，直到最后不能再分的时候就开始处理，
 * 分治就是利用了递归的思想，来依据思想写一哈
 */
	private static int[][] table;
	public static void partition(int table[][],int n){
		if(n == 1){
			table[0][0] = 1;
			return;
		}
		//左上角你已经帮我搞定了
		int m = n/2;
		partition(table,m);
		//右上角打印
		for(int i = 0;i<m;i++){
			for(int j = m;j<n;j++){
				table[i][j] = table[i][j-m]+m;
			}
		}
		//左下角打印
		for(int i = 0;i<m;i++){
			for(int j = m;j<n;j++){
				table[j][i] = table[j-m][i]+m;
			}
		}
		//右下角打印
		for(int i = 0;i<m;i++){
			for(int j = 0;j<m;j++){
				table[i+m][j+m]=table[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		table = new int[8][8];
		partition(table, 8);
		for(int i = 0;i<8;i++){
			for(int j = 0;j<8;j++){
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
	}
}
