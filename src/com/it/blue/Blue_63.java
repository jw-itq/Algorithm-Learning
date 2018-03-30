package com.it.blue;

//求数组的逆序对
public class Blue_63 {
	int m = 0;
	 public int count(int[] A, int n) {
	     // write code here
		 for(int i = 0;i<n;i++){
			 f(A,A[i],i);
		 }
		 return m;
	 }
	private void f(int[] a, int i,int n) {
		if(a.length==n){
			f(a,i,n-1);
			return;
		}
		if(n<0){
			return;
		}
		if(a[n]>i){
			m++;
			System.out.println(a[n]+"  "+i);
		}
		f(a,i,n-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,0};
		System.out.println(new Blue_63().count(arr, 8));
	}
}
