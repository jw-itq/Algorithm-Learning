package com.it.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Blue_35 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n;
		List<TreeMap<Integer, String>> list = new ArrayList<TreeMap<Integer, String>>();
		while((n=scan.nextInt())!=-1){
			TreeMap<Integer, String> map = new TreeMap<>();
			for(int k = 0;k<n;k++){
				int bb=1;
				for(int i = 0;i<3;i++){
					bb *= scan.nextInt();
				}
				String name = scan.next();
				map.put(bb,name );
			}
			list.add(map);
		}
		
		for(TreeMap<Integer, String> srt : list){
			List<Integer> sum = new ArrayList<>();
			Set<Integer> set = srt.keySet();
			for(Integer t : set){
				sum.add(t);
			}
			System.out.println(srt.get(sum.get(sum.size()-1))+" took clay from "+srt.get(sum.get(0))+".");
		}
	}
}
