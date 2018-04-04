package com.it.blue;

public class Blue_66 {
	/**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
    	int num=0;
    	for(int i = 0;i<A.length();i++){
    		for(int j = 0;j<B.length();j++){
    			int count=0;
    			int t = 0;
    			while(j+t<B.length()&&i+t<A.length()&&A.charAt(i+t)==B.charAt(j+t)){
    				t++;
    				count++;
    			}
    			if(num<count){
    				num = count;
    			}
    		}
    	}
    	return num;
    }
    
    public static void main(String[] args) {
		String a = "www.lintcode.com code";
		String b = "www.ninechapter.com code";
		System.out.println(new Blue_66().longestCommonSubstring(a, b));
	}
}
