package com.it.blue;

public class Blue_69 {
	/**
	 * 
	 * Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

来源: 实验楼
链接: https://www.shiyanlou.com/courses/492
本课程内容，由作者授权实验楼发布，未经允许，禁止转载、下载及非法传播
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome1(String s) {
        // write your code here
    	char[] ch = s.toCharArray();
    	String str = "";
    	for(int i = 0;i<ch.length;i++){
    		if(ch[i]<='z'&&ch[i]>='a'||ch[i]>='A'&&ch[i]<='Z'||ch[i]<='9'&&ch[i]>='0'){
    			str+=ch[i];
    		}
    	}
    	str = str.toLowerCase();
    	System.out.println(str);
    	ch = str.toCharArray();
    	int i = 0;
    	for(;i<ch.length/2;i++){
    		if(ch[i]==ch[ch.length-i-1]){
    			System.out.println(ch[i]+"   "+ch[ch.length-i-1]);
    		}else{
    			break;
    		}
    	}
    	if(i!=ch.length/2){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    public boolean isPalindrome(String s) {
    	if(s==null||s.isEmpty()==true){
    		return true;
    	}
    	int l = 0,r = s.length()-1;
    	while(l < r){
    		if(!Character.isLetterOrDigit(s.charAt(l))){
    			l++;
    			continue;
    		}
    		if(!Character.isLetterOrDigit(s.charAt(r))){
    			r--;
    			continue;
    		}
    		if(Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))){
    			l++;
    			r--;
    		}else{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new Blue_69().isPalindrome(s));
	}
    
}
