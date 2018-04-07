package com.it.blue;

public class Blue_71 {
	/**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     * isMatch("cabacwb", "*a*b") �� false

��Դ: ʵ��¥
����: https://www.shiyanlou.com/courses/492
���γ����ݣ���������Ȩʵ��¥������δ��������ֹת�ء����ؼ��Ƿ�����
     */
	int tt=0;
    public boolean isMatch(String s, String p) {
        // write your code here
    	if(s==null||p==null){
    		return false;
    	}
    	if(s.isEmpty()||s.isEmpty()){
    		return false;
    	}
    	return helper(s,0,p,0);
    }
	
	private boolean helper(String s, int si, String p, int pj) {
		System.out.println(tt++);
		if(si==s.length()||pj==p.length()){
			if(si==s.length()&&pj==p.length()){
				return true;
			}else if(si==s.length()){
				if(pj+1==p.length()&&(p.charAt(pj)=='*'||p.charAt(pj)=='?')){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		if(p.charAt(pj)=='*'){
			//��*��ȥ��������˵ȥ���ظ��ģ���pjָ��*�ź����Ǹ��ַ�
			while(p.charAt(pj)=='*'){
				pj++;
				if(pj==p.length()){
					return true;
				}
			}
			//׼�������жϣ�����˵ֻ������s[si]ĳ���ַ���p[pj]�е�ĳ���ַ�һģһ����ʱ��
			//�Ҳ�Ҫ������ָ�붼������ƶ�һ��������֮����ᷢ�ֺ�����ղ�һģһ���˹�����
			//��ʱ���Ҫ�ǵݹ�Ҫ�õ�ʱ���ˣ�Ҳ��˵������ָ���֮ǰ�����һģһ����ʱ���Ҫ
			//���õݹ��ʩ�������һ���Ļ�����Ӧ��Ҫ��s�����ܵ���ǰ�ƽ���ֱ��s���꣬pҲ����
			//�����Ļ�����˵����ƥ��ģ�Ҫ��p�����ˣ�sû�������أ��ǵ�Ȼ�ǲ������������ݹ飬
			//Ҫ������Ҫ��s�����ˣ�pû�������أ����Ǹ�ʲô��������أ��ñ�˵��ab������ab����
			while(si<s.length()&&!helper(s, si, p, pj)){
				si++;
			}
			//��si��û�������ʱ��ȻҪ������ǰ���ߣ�������Ҫ�ǻ�Ҫ�����Ļ���Խ����
			return si!=s.length();
		}else if(s.charAt(si)==p.charAt(pj)||p.charAt(pj)=='?'){//������Ȼ����и����Ļ�����ǰ��һ��
			return helper(s, si+1, p, pj+1);
		}else{
			return false;//���򷵻�false
		}
	}
	
/*
������

����s�е�ÿ��Ԫ��
If * s == * p��* p ==������ζ������һ��ƥ�䣬Ȼ��ת����һ��Ԫ��s ++ p ++��
���p =='*'����Ҳ��һ��ƥ�䣬���ǿ�����һ�������ַ����ã����������Ǳ������*��λ�ú�ƥ���λ�á�
�����ƥ�䣬��ô���Ǽ���Ƿ���*��ǰ���֣�
       ���û��*���򷵻�false; 
       �����*�����ǽ���ǰp����Ϊ*����һ��Ԫ�أ�������ǰs����Ϊ��һ�������sλ�á�

����

abed 
?b*d** 

a =����������b = b��������
e = *������* position star = 3������sλ��ss = 3��p ++ 
e��= d������Ƿ����a *���ǣ�ss ++��s = ss; p = star + 1 
d = d��������������
���p�е�����Ԫ�أ��������*��true������Ϊfalse;

c++����:

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
         
        const char* star=NULL;
        const char* ss=s; 
        while (*s){
            if ((*p=='?')||(*p==*s)){s++;p++;continue;}
            if (*p=='*'){star=p++; ss=s;continue;}
            if (star){ p = star+1; s=++ss;continue;}
            return false;
        }
        while (*p=='*'){p++;}
        return !*p;
    }
};
 */
	public boolean isMatch1(String s, String p){
		int ss = 0,star = 0,i=0,j=0;
		while(i<s.length()){
			if(j<p.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
				i++;j++;continue;
			}
			if(j<p.length()&&(p.charAt(j)=='*')){
				ss = i;
				star = j++;
				continue;
			}
			if(p.charAt(star)=='*'){
				i = ++ss;
				j = star+1;
				continue;
			}
			return false;
		}
		while(j<p.length()&&p.charAt(j)=='*'){
			j++;
		}
		return j==p.length();
	}

	public static void main(String[] args) {
		System.out.println(new Blue_71().isMatch1("aa","aa"));
	}
}
