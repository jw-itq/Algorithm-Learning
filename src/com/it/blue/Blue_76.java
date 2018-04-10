package com.it.blue;

public class Blue_76 {
	//递归求阶乘
/*
 * 首先我来分析哈阶乘如何用递归来做，一定要想简单一些：
 * 3！= 3*2*1；2！ = 2*1；1！=1*1；因为我之前就做过，所以现在想就很简单了
 * 这样想我求N！也就是说我要求N*（N-1）！；当N-1等于1的时候返回1就可以了
 */
	public static int fact(int n){
		if(n == 1){
			return 1;
		}
		return n*fact(n-1);
	}
	
/*
 *泊松倒酒12L  8L  5L   倒出6L
 *老师说要指定一个策略就是说不能瞎倒，规定1---->2----->3----1
 *我要总结一哈，很明显，递归的话千万别去想过程，一定要想思想！！！
 */
	private static int b1 = 12;
	private static int b2 = 8;
	private static int b3 = 5;
	private static int m = 6;
	//这里先假设一哈，假说12,0,0
	public static void backBottle(int bb1,int bb2,int bb3){
		//什么时候不需要倒酒了？
		//说算法要设计的严谨，意思就是所不能只适应这一组输入，有可能还有其他的输入的值
		if(bb1 == m||bb2 == m||bb3 == m){
			System.out.println("可以倒出"+m+"升酒");
			return;
		}
		//从bb2开始判断哈，因为它是第一个装满的
		//这样判断的意思就是说可以倒！首先就要判断可不可以倒
		System.out.println(bb1+"****"+bb2+"****"+bb3);
		if(bb2!=0&&bb3!=b3){
			if(bb2+bb3 <= b3){
				backBottle(bb1, 0, bb2+bb3);
			}else{
				backBottle(bb1, bb2-(b3-bb3), b3);
			}
		}else if(bb3 == b3){
			if(bb3+bb1 <= b1){
				backBottle(bb1+bb3, bb2, 0);
			}else{
				backBottle(b1, bb2, bb3-(b1-bb1));
			}
		}else if(bb2!=b2){
			if(bb1+bb2 <= b2){
				backBottle(0, bb1+bb2, bb3);
			}else{
				backBottle(bb1-(b2-bb2), b2, bb3);
			}
		}
	}
	public static void main(String[] args) {
//		System.out.println(fact(20));
		backBottle(12, 0, 0);
	}
}
