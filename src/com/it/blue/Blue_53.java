package com.it.blue;

import java.util.ArrayList;
import java.util.List;

public class Blue_53 {
	/**
	 * 
	 * @param stack 栈
	 * @param top 栈的大小
	 * @return 返回反转后的栈
	 */
	static List<Integer> list = new ArrayList<Integer>();
	public int[] reverseStackRecursively(int[] stack, int top) {
        // write code here
		if(top!=0){
			list.add(stack[top-1]);
			return reverseStackRecursively(stack, top-1);
		}
		Integer[] art = list.toArray(new Integer[]{});
		int[] ser = new int[art.length];
		for(int i = 0;i<art.length;i++){
			ser[i] = art[i];
		}
		return ser;
    }
	public static void main(String[] args) {
		int[] arr = {35,577,496,43,46,586,537,339,605,354,221};
		Blue_53 b = new Blue_53();
		arr = b.reverseStackRecursively(arr, 11);
		for(int t : arr){
			System.out.print(t);
		}
		System.out.println();
		for(int t : list){
			System.out.print(t);
		}
	}
}
