package com.it.blue;

public class Blue_76 {
	//�ݹ���׳�
/*
 * ���������������׳�����õݹ�������һ��Ҫ���һЩ��
 * 3��= 3*2*1��2�� = 2*1��1��=1*1����Ϊ��֮ǰ������������������ͺܼ���
 * ����������N��Ҳ����˵��Ҫ��N*��N-1��������N-1����1��ʱ�򷵻�1�Ϳ�����
 */
	public static int fact(int n){
		if(n == 1){
			return 1;
		}
		return n*fact(n-1);
	}
	
/*
 *���ɵ���12L  8L  5L   ����6L
 *��ʦ˵Ҫָ��һ�����Ծ���˵����Ϲ�����涨1---->2----->3----1
 *��Ҫ�ܽ�һ���������ԣ��ݹ�Ļ�ǧ���ȥ����̣�һ��Ҫ��˼�룡����
 */
	private static int b1 = 12;
	private static int b2 = 8;
	private static int b3 = 5;
	private static int m = 6;
	//�����ȼ���һ������˵12,0,0
	public static void backBottle(int bb1,int bb2,int bb3){
		//ʲôʱ����Ҫ�����ˣ�
		//˵�㷨Ҫ��Ƶ��Ͻ�����˼����������ֻ��Ӧ��һ�����룬�п��ܻ��������������ֵ
		if(bb1 == m||bb2 == m||bb3 == m){
			System.out.println("���Ե���"+m+"����");
			return;
		}
		//��bb2��ʼ�жϹ�����Ϊ���ǵ�һ��װ����
		//�����жϵ���˼����˵���Ե������Ⱦ�Ҫ�жϿɲ����Ե�
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
