package com.it.blue;

/*
 * 全排列算法的学习
 */
import java.util.ArrayList;
import java.util.List;

public class Blue_30 {
	
	/**
	 * 全排列的算法
	 * @param args
	 */
	public static void main(String[] args) {
		List<Character> s = new ArrayList<Character>();
		List<Character> rs = new ArrayList<Character>();
		for(int i = 1;i<=3;i++){
			s.add((char) ('0'+i));
		}
		pl(s,rs);
	}
	
	public static void pl(List<Character> s,List<Character> rs){
		if(s.size()==1){
			rs.add(s.get(0));
			System.out.println(rs.toString());
			rs.remove(rs.size()-1);
		}else{
			for(int i = 0;i<s.size();i++){
				rs.add(s.get(i));
				List<Character> tmp = new ArrayList<Character>();
				for(Character t : s){
					tmp.add(t);
				}
				tmp.remove(i);
				pl(tmp,rs);
				rs.remove(rs.size()-1);
			}
		}
	}
}
