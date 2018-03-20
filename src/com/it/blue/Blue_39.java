package com.it.blue;

import java.util.Scanner;

public class Blue_39 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] a = scan.nextLine().toCharArray();
		char[] b = scan.nextLine().toCharArray();
		int i = 0;
		while(i<a.length){
			if(a[i]!=b[i]){
				System.out.print(0);
			}else{
				System.out.print(1);
			}
			i++;
		}
		
	}
}	
