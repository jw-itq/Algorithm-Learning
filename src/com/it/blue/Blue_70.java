package com.it.blue;

public class Blue_70 {
	/**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome1(String s) {
        // write your code here
    	String result = new String();
    	if(s==null||s.isEmpty()){
    		return result;
    	}
    	int n = s.length();
    	int len = 0,left = 0,right = 0;
    	for(int i = 0;i<n;i++){
    		for(int j = i+1;j<=n;j++){
    			String cen = s.substring(i,j);
    			if(isPanlindrome1(cen)&&cen.length()>len){
    				len = cen.length();
    				left = i;
    				right = j;
    			}
    		}
    	}
    	result = s.substring(left,right);
    	return result;
    }
    public boolean isPanlindrome1(String s){
    	for(int i = 0;i<s.length()/2;i++){
    		if(s.charAt(i)!=s.charAt(s.length()-i-1)){
    			return false;
    		}
    	}
    	return true;
    }
    
    public String longestPalindrome(String s){
    	String res = "";
    	for(int i = 0;i<s.length();i++){
    		if(isPanlindrome(s,i,i).length()>res.length()){
    			res = isPanlindrome(s, i, i);
    		}
    		if(isPanlindrome(s,i,i+1).length()>res.length()){
    			res = isPanlindrome(s, i, i+1);
    		}
    		
    	}
    	return res;
    }
    public String isPanlindrome(String s,int l,int r){
    	while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
    		l--;
    		r++;
    	}
    	if(l+1>r-1){
    		return s.substring(l,r);
    	}
    	return s.substring(l+1,r);
    }
    public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(new Blue_70().longestPalindrome(s));
	}
}
