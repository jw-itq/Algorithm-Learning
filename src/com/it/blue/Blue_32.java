package com.it.blue;

import java.util.Scanner;

/*
 * LIS������������С�ʲô������������У� 
 * ���Ǹ���һ�����У��������������һ����ϸ�
 * �����Ĳ��֣�����һ��Ҫ����������������22, 33, 44, 77 
 * �� 22, 33, 44, 66 �������� 22 55 33 44 11 77 66 ��
 * �������������У���ĳ����� 44��
 */
public class Blue_32 {
	    public static final int N = 1000;
	    public static int[] f = new int[N];
	    public static int[] b = new int[N];

	    public static int max(int a, int b) {
	        if (a > b) {
	            return a;
	        }
	        return b;
	    }

	    public static int lis(int n) {
	        int res = 0;
	        for (int i = 0; i < n; ++i) {
	            for (int j = 0; j < i; ++j) {
	                if (b[j] < b[i]) {
	                 f[i] = max(f[i],f[j]+1);
	                }
	            }
	            res = max(res, f[i]);
	        }
	        return res+1;
	    }

	    public static void main(String[] args) {
	        Scanner cin = new Scanner(System.in);

	        int n = cin.nextInt();
	        for (int i = 0; i < n; ++i) {
	        	b[i] = cin.nextInt() ;
	        }
	        System.out.println(lis(n));
	    }
}
