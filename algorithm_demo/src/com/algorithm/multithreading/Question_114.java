package com.algorithm.multithreading;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数?numRows，生成杨辉三角的前?numRows?行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
