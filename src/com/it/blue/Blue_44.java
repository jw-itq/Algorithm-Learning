package com.it.blue;

import java.util.Scanner;

//�ж�һ�����ǲ���2�Ĵη��������2�Ĵη�2������������
public class Blue_44 {
	
	public static int pan(int n){
		int t = 0;
		while(n>=1){
			if((n&1)==1){
				t++;
			}
			n>>=1;
		}
		return t;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if((n&n-1)==0){
			System.out.println("��2�Ĵη�");
		}else{
			System.out.println("����2�Ĵη�");
		}
		System.out.println(n+"�Ķ���������"+pan(n)+"��1");
	}
}
