package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class test {
	public static void main(String[] args) {
//		Map<String, Integer> items = new HashMap<>();
//		items.put("A", 10);
//		items.put("B", 20);
//		items.put("C", 30);
//		
//		Map<String, Integer> lists = new HashMap<>();
//		
//		items.forEach((k,v)->{
//		    items.replace(k, v*2);
//		});
//		System.out.println(items.get("A"));
		
//		Map<String, Double> map = new HashMap<String, Double>();
//        map.put("c", 4.0);
//        map.put("a", 2.0);
//        map.put("b", 1.0);
//        map.put("d", 3.0);
//        List<Map.Entry<String,Double>> list = new ArrayList<Map.Entry<String,Double>>(map.entrySet());
//        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
//            //升序排序
//            public int compare(Entry<String, Double> o1,
//                    Entry<String, Double> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        for(Map.Entry<String,Double> mapping:list){ 
//            System.out.println(mapping.getKey()+":"+mapping.getValue()); 
//       }
		System.out.println(String.format("select lit_title from %s where lit_id=%s", "h","ha"));
	}
	
}
