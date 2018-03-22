package com.it.blue;

import java.util.Scanner;

//判断一个数是不是2的次方，如果是2的次方2进制数很特殊
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
			System.out.println("是2的次方");
		}else{
			System.out.println("不是2的次方");
		}
		System.out.println(n+"的二进制中有"+pan(n)+"个1");
	}
}
