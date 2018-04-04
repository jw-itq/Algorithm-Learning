package com.it.blue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of strings, return all groups of strings that are anagrams.

Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
Note
All inputs will be in lower-case
 */
public class Blue_65 {
	public static List<String> groupAnagram(String[] s){
		List<String> list = new ArrayList<String>();
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		Map<String, Integer> numap = new HashMap<String,Integer>();
		for(String t : s){
			char[] ch = t.toCharArray();
			Arrays.sort(ch);
			String st = String.valueOf(ch);
			if(map.containsKey(st)){
				ArrayList<String> arr = map.get(st);
				arr.add(t);
				map.put(st, arr);
				int i = numap.get(st);
				numap.put(st, i+1);
			}else{
				ArrayList<String> arr = new ArrayList<String>();
				arr.add(t);
				map.put(st, arr);
				numap.put(st, 0);
			}
		}
		
		Set<String> keyset = map.keySet();
		Set<String> numset = numap.keySet();
		for(String k : numset){
			if(numap.get(k)!=0){
				ArrayList<String> alist = map.get(k);
				for(String i : alist){
					list.add(i);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		String[] str = {"lint", "intl", "inlt", "code"};
		List<String> list = groupAnagram(str);
		for(String t : list){
			System.out.print(t+" ");
		}
	}
}
