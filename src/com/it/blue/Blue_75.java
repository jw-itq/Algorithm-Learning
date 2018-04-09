package com.it.blue;

//汉诺塔和欧几里得算法
public class Blue_75 {
	//这个方法表示的意思就是第N个盘子从from借助dependOn挪动到to
	//之前为什么没有理解是因为老是想过程去了，过程是想不明白的，一定要把握原本的意思
	public static void hanNoi(int n ,char from ,char dependOn,char to){
		//直到最后的时候，也就是只剩下一个的时候就只需要从从A挪动到C
		if(n == 1){
			move(1,from,to);
		}else{
			hanNoi(n-1, from, to, dependOn);
			move(n,from,to);
			hanNoi(n-1, dependOn, from, to);
		}
	}

	private static void move(int i, char from, char to) {
		System.out.println("第"+i+"个盘子从"+from+"挪动到了"+to);
	}
	
	//最大公约数欧几里得算法：m > n;最大公约数就是n 和m%n的最大公约数
	//为什么当然不知道，但是到底是不是呢，举个例子
	//36 24，最大公约数就应该是24 和36%24=12,就是24和12的最大公约数，其实就是12
	//因为这里很明显就能够看得出来是递归，所以要归纳一哈
	//不断交替递归取模，然后直到最小的那个等于0的时候，那么另一个肯定就是最大公约数
	public static void gcd(int m,int n){
		if(n == 0){
			System.out.println(m);
			return;
		}
		if(m < n){
			int t = m;
			m = n;
			n = t;
		}
		gcd(n,m%n);
	}
	public static void main(String[] args) {
//		hanNoi(3, 'A', 'B', 'C');
		gcd(36,24);
	}
}
