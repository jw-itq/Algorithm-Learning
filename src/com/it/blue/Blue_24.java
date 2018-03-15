package com.it.blue;

import java.util.Scanner;

/**
 * DFS
 * @author Administrator
 *
 */
public class Blue_24 {
	static int n,m;
	static char[][] grid;
	static int[][] art = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void dfs(int x ,int y){
		int xx,yy;
		grid[x][y]='*';
		for(int i = 0;i<8;i++){
			xx = x+art[i][0];
			yy = y+art[i][1];
			if(xx<0||xx>=n||yy<0||yy>=m){
				continue;
			}
			if(grid[xx][yy]=='@'){
				dfs(xx,yy);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		grid = new char[n][m];
		int cnt=0;
		for(int i = 0;i<n;i++){
			grid[i] = scan.next().toCharArray(); 
		}
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				if(grid[i][j]=='@'){
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
