package com.it.blue;

import java.util.ArrayList;
import java.util.List;

public class Blue_56 {
	private List<String> list = new ArrayList<String>();
	public String[] getGray1(int n) {
        // write code here
		
		if(n==1||n==0){
			list.add(n+"");
			list.add(0+"");
			int len = list.size();
			String[] str = new String[len];
			for(int i = 0;i<list.size();i++){
				str[i]=list.get(len-(i+1));
			}
			return str;
		}
		char[] art = Integer.toBinaryString(n).toCharArray();
			int a = Integer.parseInt(art[art.length-1]+"");
			int b = Integer.parseInt(art[art.length-2]+"");
			list.add((a^b)+"");
			return getGray(n>>=1);
			
    }
	//生成格雷码,递归的思想就是首先得到1的格雷码【0，1】，然后上一层的格雷码就是这一层的格雷码加1跟0
	//的结果，所以现在的问题就是如何给‘0，1’添加1跟0，上一层的大小肯定就是这一层的两倍，因此返回的
	//字符串数组就是两倍的大小，演算一下就得到结果了。最主要的递归的想法，递归肯定就是一模一样的操作！
	public String[] getGray(int n) {
        // write code here
		String[] graies = null;
		if(n==1){
			graies = new String[]{"0","1"};
		}else{
			String[] str = getGray(n-1);
			graies = new String[2*str.length];
			for(int i = 0;i<str.length;i++){
				graies[i]="0"+str[i];
				graies[graies.length-i-1]="1"+str[i];
			}
		}
		return graies;
			
    }
	public static void main(String[] args) {
		String[] str = new Blue_56().getGray(2);
		for(String t : str){
			System.out.print(t+" ");
		}
	}
}
