package com.it.blue;

public class Test6 {
	static int[] a = new int[13];
	static int[] b = new int[13];
	static int t = 0;
	public static void main(String[] args) {
		a[1] = 1;
		a[2] = 8;
		a[12] = 3;
		b[1] = 1;
		b[8] = 1;
		b[3] = 1;
		dfs(1);
	}

	private static void dfs(int x) {
		System.out.println("t的值为"+t++);
		System.out.println();
		if(x == 1||x==2||x==12){
			dfs(x+1);
			return;
		}
		if(x==13){
			jude();
		}
		for(int i = 1;i<13;i++){
			System.out.println("这是循环这是循环");
			if(b[i]==0){
				b[i] = 1;
				a[x] = i;
				System.out.println("——————————————————————————前面x的值为"+x+"==i的值为"+i);
				dfs(x+1);
				System.out.println("后面x的值为"+x+"i的值为"+i);
				b[i] = 0;
			}
		}
	}
	
	public static void jude()  
	{  
	    int[] b1 = new int[6]; 
	      
	    b1[0]=a[1]+a[3]+a[6]+a[8];   
	    b1[1]=a[1]+a[4]+a[7]+a[11];  
	    b1[2]=a[2]+a[3]+a[4]+a[5];  
	    b1[3]=a[2]+a[6]+a[9]+a[12];  
	    b1[4]=a[5]+a[7]+a[10]+a[12];  
	    b1[5]=a[8]+a[9]+a[10]+a[11];  
	      
	    for(int i=1;i<6;i++){   
	        if(b1[i]!=b1[i-1])  
	            return; 
	    }
	    System.out.println("答案答案答案"+a[6]);  
	}  
}
