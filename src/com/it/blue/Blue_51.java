package com.it.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * ��һ���ܳ���խ��ֽ������ֽ�����ŷ��������ϣ�Ȼ���ֽ�����±����Ϸ�����1�Σ�ѹ���ۺۺ�չ������ʱ�ۺ��ǰ���ȥ�ģ�Ҳ����ͻ��ķ���ָ��ֽ�����·��� 
�����ֽ�����±����Ϸ�����2�Σ�ѹ���ۺۺ�չ������ʱ�������ۺۣ����ϵ��������ǣ����ۺۡ����ۺۡ����ۺۣ� 
���ֽ��ÿ�ζ����±����Ϸ����ۣ��ڶ���n��֮��չ������ʱ�����ۺ�ͻ��ķ�����ʲô�����أ� 
��дһ������������һ����������ֽ���Ķ��۴�����ΪfTimes�����ϵ������δ�ӡ�����ۺ۵�ͻ���� 
���磺 
fTimes = 1 
��ӡ��down 
fTimes = 2 
��ӡ��down down up
��ʾ���ۺ���ʵ�Ƕ������ṹ���ö��������ص��ǣ����ڵ����£�ÿһ���ڵ����ڵ����£��ҽڵ����ϡ��ö����������������Ϊ�𰸣�������Ҫ����һ�Ŷ��������õݹ鷽���ɴ�ӡ������
 */

public class Blue_51 {
   static List<String> list = new ArrayList<String>();
   
   public static void fotd(int n,int N,boolean bl){
	   if(n>N){
		   return;
	   }
	   fotd(n+1,N,true);
	   list.add(bl?"down":"up");
	   fotd(n+1,N,false);
   }
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n= scan.nextInt();
	fotd(1,n,true);
	for(String t : list){
		System.out.print(t+" ");
	}
}
}
