package com.it.blue;

import java.io.IOException;
/*
 * 最近蒜头君喜欢上了U型数字，所谓U型数字，
 * 就是这个数字的每一位先严格单调递减，后严格单调递增。
 * 比如 212212 就是一个U型数字，但是 333333, 9898, 567567, 3131331313，
 * 就是不是U型数字。现在蒜头君问你，[1,100000][1,100000] 有多少U型数字？
 */
public class Blue_31 {
	public static void main(String[] args) throws IOException {

		int sum = 0;
		for (int i = 100; i <= 100000; i++) {
			String str = String.valueOf(i);
			char[] a = str.toCharArray();// 将数字的每一位存进数组
			int j;
			boolean flag = false, f = false;
			for (j = 1; j < a.length; j++) {// 判断前一半是否是逐级递减
				if (a[j - 1] > a[j]) {
					flag = true;
				} else
					// 不是就跳出循环
					break;
			}
			for (; j < a.length; j++) // 判断后半部分是否是逐级递增
			{
				if (a[j - 1] < a[j]) {
					if (j == a.length - 1) // 循
						f = true;
				} else // 不是就跳出循环
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
