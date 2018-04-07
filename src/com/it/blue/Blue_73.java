package com.it.blue;

//ÏêÏ¸½â²Î¿¼http://www.cnblogs.com/huntfor/p/3849547.html
public class Blue_73 {
	/**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        // write your code here
    	if(n<=0){
    		return null;
    	}
    	String s = "1";
    	int count = 1;
    	while(n--!=1){
    		StringBuffer sb = new StringBuffer();
    		for(int j = 0;j<s.length();j++){
    			if(j<s.length()-1&&s.charAt(j)==s.charAt(j+1)){
    				count++;
    			}else{
    				sb.append(count+""+s.charAt(j));
    				count = 1;
    			}
    		}
    		s = sb.toString();
    	}
    	return s;
    }
    public static void main(String[] args) {
		System.out.println(new Blue_73().countAndSay(4));
	}
}
