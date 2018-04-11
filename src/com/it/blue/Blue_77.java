package com.it.blue;

public class Blue_77 {
//����ӷ���������õ����㷨�Ƿ���
/*
 * ˼�������ף����ǲ��ϵķ��Σ��ֶ���֮��ֱ��������ٷֵ�ʱ��Ϳ�ʼ����
 * ���ξ��������˵ݹ��˼�룬������˼��дһ��
 */
	private static int[][] table;
	public static void partition(int table[][],int n){
		if(n == 1){
			table[0][0] = 1;
			return;
		}
		//���Ͻ����Ѿ����Ҹ㶨��
		int m = n/2;
		partition(table,m);
		//���ϽǴ�ӡ
		for(int i = 0;i<m;i++){
			for(int j = m;j<n;j++){
				table[i][j] = table[i][j-m]+m;
			}
		}
		//���½Ǵ�ӡ
		for(int i = 0;i<m;i++){
			for(int j = m;j<n;j++){
				table[j][i] = table[j-m][i]+m;
			}
		}
		//���½Ǵ�ӡ
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
