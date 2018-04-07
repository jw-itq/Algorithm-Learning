package com.it.blue;

public class Blue_71 {
	/**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     * isMatch("cabacwb", "*a*b") → false

来源: 实验楼
链接: https://www.shiyanlou.com/courses/492
本课程内容，由作者授权实验楼发布，未经允许，禁止转载、下载及非法传播
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
			//把*号去掉，就是说去掉重复的，让pj指向*号后面那个字符
			while(p.charAt(pj)=='*'){
				pj++;
				if(pj==p.length()){
					return true;
				}
			}
			//准备挨个判断，就是说只有遇到s[si]某个字符跟p[pj]中的某个字符一模一样的时候
			//我才要将两个指针都向后面移动一个，完了之后你会发现好像跟刚才一模一样了哈，这
			//个时候就要是递归要用的时候了，也就说如果发现跟你之前推理的一模一样的时候就要
			//采用递归措施，如果不一样的话，我应该要将s尽可能的向前推进，直到s走完，p也走完
			//这样的话，就说明是匹配的，要是p走完了，s没有走完呢，那当然是不能让它结束递归，
			//要继续，要是s走完了，p没有走完呢，这是个什么样的情况呢，好比说‘ab’，‘ab？’
			while(si<s.length()&&!helper(s, si, p, pj)){
				si++;
			}
			//当si还没有走完的时候当然要继续往前面走，走完了要是还要继续的话就越界了
			return si!=s.length();
		}else if(s.charAt(si)==p.charAt(pj)||p.charAt(pj)=='?'){//两个相等或者有个？的话都往前推一个
			return helper(s, si+1, p, pj+1);
		}else{
			return false;//否则返回false
		}
	}
	
/*
分析：

对于s中的每个元素
If * s == * p或* p ==？这意味着这是一个匹配，然后转到下一个元素s ++ p ++。
如果p =='*'，这也是一个匹配，但是可能有一个或多个字符可用，所以让我们保存这个*的位置和匹配的位置。
如果不匹配，那么我们检查是否有*先前出现，
       如果没有*，则返回false; 
       如果有*，我们将当前p设置为*的下一个元素，并将当前s设置为下一个保存的s位置。

例如

abed 
?b*d** 

a =？，继续，b = b，继续，
e = *，保存* position star = 3，保存s位置ss = 3，p ++ 
e！= d，检查是否存在a *，是，ss ++，s = ss; p = star + 1 
d = d，继续，结束。
检查p中的其余元素，如果都是*，true，否则为false;

c++代码:

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
