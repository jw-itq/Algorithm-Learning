package com.it.blue;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Blue_38 {
	
	public static int gong(int x,int y){
		int t = 0;
		if(x%y==0){
			return y;
		}
		while(x%y!=0){
			t = x%y;
			x = y;
			y = t;
		}
		return t;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Double> map = new HashMap<String, Double>();
		int n = scan.nextInt();
		for(double i = 1.0;i<=n;i++){
			for(double j=0.0;j<=i;j++){
				if(j/i<=1&&j/i>=0&&gong((int)j,(int)i)==1){
					map.put((int)j+"/"+(int)i, j/i);
				}
			}
		}
		
		Set<Entry<String, Double>> entries = map.entrySet();
		List<Entry<String, Double>> list = new LinkedList<Entry<String,Double>>(entries);
		Collections.sort(list,new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1,
					Entry<String, Double> o2) {
				
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Entry<String, Double> en : list){
			System.out.println(en.getKey());
		}
	}
}
