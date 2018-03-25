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
	//���ɸ�����,�ݹ��˼��������ȵõ�1�ĸ����롾0��1����Ȼ����һ��ĸ����������һ��ĸ������1��0
	//�Ľ�����������ڵ����������θ���0��1�����1��0����һ��Ĵ�С�϶�������һ�����������˷��ص�
	//�ַ���������������Ĵ�С������һ�¾͵õ�����ˡ�����Ҫ�ĵݹ���뷨���ݹ�϶�����һģһ���Ĳ�����
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
