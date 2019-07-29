package com.algorithm.multithreading;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���Ǹ�����?numRows������������ǵ�ǰ?numRows?�С�
 *
 *
 *
 * ����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
 *
 * ʾ��:
 *
 * ����: 5
 * ���:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/pascals-triangle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Question_114 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 1;i<=numRows;i++){
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            for(int j = 0;j<i-2;j++){
                nums.add(list.get(i-2).get(j)+list.get(i-2).get(j+1));
            }
            if(i != 1){
                nums.add(i-1,1);
            }
            list.add(nums);
        }

        System.out.println(list);

        return list;
    }

    public static void main(String[] args){
        generate(10);
    }
}
