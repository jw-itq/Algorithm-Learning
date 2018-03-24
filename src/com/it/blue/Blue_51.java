package com.it.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * 给一个很长很窄的纸条，把纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开，此时折痕是凹下去的，也就是突起的方向指向纸条的下方； 
如果从纸条的下边向上方对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是：下折痕、下折痕、上折痕； 
如果纸条每次都从下边向上方对折，在对折n次之后展开。此时所有折痕突起的方向是什么样的呢？ 
请写一个函数，输入一个整数代表纸条的对折次数记为fTimes，从上到下依次打印所有折痕的突起方向。 
例如： 
fTimes = 1 
打印：down 
fTimes = 2 
打印：down down up
提示：折痕其实是二叉树结构。该二叉树的特点是：根节点是下，每一个节点的左节点是下，右节点是上。该二叉树的中序遍历即为答案，但不需要构造一颗二叉树，用递归方法可打印出来。
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
