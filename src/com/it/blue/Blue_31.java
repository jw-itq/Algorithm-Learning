package com.it.blue;

import java.io.IOException;
/*
 * �����ͷ��ϲ������U�����֣���νU�����֣�
 * ����������ֵ�ÿһλ���ϸ񵥵��ݼ������ϸ񵥵�������
 * ���� 212212 ����һ��U�����֣����� 333333, 9898, 567567, 3131331313��
 * ���ǲ���U�����֡�������ͷ�����㣬[1,100000][1,100000] �ж���U�����֣�
 */
public class Blue_31 {
	public static void main(String[] args) throws IOException {

		int sum = 0;
		for (int i = 100; i <= 100000; i++) {
			String str = String.valueOf(i);
			char[] a = str.toCharArray();// �����ֵ�ÿһλ�������
			int j;
			boolean flag = false, f = false;
			for (j = 1; j < a.length; j++) {// �ж�ǰһ���Ƿ����𼶵ݼ�
				if (a[j - 1] > a[j]) {
					flag = true;
				} else
					// ���Ǿ�����ѭ��
					break;
			}
			for (; j < a.length; j++) // �жϺ�벿���Ƿ����𼶵���
			{
				if (a[j - 1] < a[j]) {
					if (j == a.length - 1) // ѭ
						f = true;
				} else // ���Ǿ�����ѭ��
				{
					break;
				}
			}
			if (flag && f) {
				System.out.println(str);
				sum++;
			}

		}
		System.out.println(sum);
	}
}
