package com.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dao.QueryResult;
import com.dao.TopDocsCollector;
import com.util.MysqlConn;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopDocsCollectorImpl implements TopDocsCollector {

	@Override
	public List<String> sort(List<QueryResult> lists) {
		// TODO Auto-generated method stub
		Map<String, Double> map = new HashMap<>();
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			HashMap<String, Double> tmp = lists.get(i).tfidf();
			tmp.forEach((k, v) -> {
				if (map.containsKey(k))
					map.replace(k, map.get(k) + v);
				else
					map.put(k, v);
			});
		}
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 降序排序
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (Map.Entry<String, Double> mapping : list) {
//            System.out.println(mapping.getKey()+":"+mapping.getValue());
			ans.add(mapping.getKey());
		}
		return ans;
	}

	public List<String> findTitle(List<String> ids, String catagory) {
		List<String> l = new ArrayList<>();
		String title = null;
		MysqlConn mc = new MysqlConn();
		mc.init();

		for (int i = 0; i < ids.size(); i++) {
			title = mc.query(catagory, ids.get(i));
			l.add(title);
		}
		mc.closeConn();
		return l;
	}
}
