package com.it.blue;

public class Blue_67 {
	/**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public char[] rotateString1(char[] str, int offset) {
        // write your code here
    	StringBuffer sb= new StringBuffer();
    	for(int i = str.length-offset;i>=0&&i<str.length;i++){
    		sb.append(str[i]);
    	}
    	for(int i = 0;i<str.length-offset;i++){
    		sb.append(str[i]);
    	}
    	str =  new String(sb).toCharArray();
    	return str;
    }
    
    public char[] rotateString(char[] str, int offset) {
    	if(str==null){
    		
    	}
    	char temp;
    	int len = str.length;
    	for(int i = 0;i<offset%len;i++){
    		temp = str[len-1];
    		int j = len-2;
    		while(j>=0){
    			str[j+1]=str[j];
    			j--;
    		}
    		str[0]=temp;
    	}
    	return str;
    }
    public static void main(String[] args) {
    	
		char[] a = new Blue_67().rotateString("abcdefg".toCharArray(), 2);
		System.out.println(String.valueOf(a));
	}
}
