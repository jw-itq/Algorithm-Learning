package com.it.blue;

//��ŵ����ŷ������㷨
public class Blue_75 {
	//���������ʾ����˼���ǵ�N�����Ӵ�from����dependOnŲ����to
	//֮ǰΪʲôû���������Ϊ���������ȥ�ˣ��������벻���׵ģ�һ��Ҫ����ԭ������˼
	public static void hanNoi(int n ,char from ,char dependOn,char to){
		//ֱ������ʱ��Ҳ����ֻʣ��һ����ʱ���ֻ��Ҫ�Ӵ�AŲ����C
		if(n == 1){
			move(1,from,to);
		}else{
			hanNoi(n-1, from, to, dependOn);
			move(n,from,to);
			hanNoi(n-1, dependOn, from, to);
		}
	}

	private static void move(int i, char from, char to) {
		System.out.println("��"+i+"�����Ӵ�"+from+"Ų������"+to);
	}
	
	//���Լ��ŷ������㷨��m > n;���Լ������n ��m%n�����Լ��
	//Ϊʲô��Ȼ��֪�������ǵ����ǲ����أ��ٸ�����
	//36 24�����Լ����Ӧ����24 ��36%24=12,����24��12�����Լ������ʵ����12
	//��Ϊ��������Ծ��ܹ����ó����ǵݹ飬����Ҫ����һ��
	//���Ͻ���ݹ�ȡģ��Ȼ��ֱ����С���Ǹ�����0��ʱ����ô��һ���϶��������Լ��
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
