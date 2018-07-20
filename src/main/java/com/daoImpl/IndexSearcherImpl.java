package com.daoImpl;


import java.util.ArrayList;
import java.util.List;

import com.dao.IndexSearcher;
import com.dao.QueryResult;
import com.entity.Reverse;
import com.util.MongoConn;

public class IndexSearcherImpl implements IndexSearcher {
	private MongoConn m = new MongoConn();
	
//	private String[] strs;
//	public IndexSearcherImpl(String[] strs) {
//		this.strs = strs;
//	}
	@Override
	public boolean connectToDB(String catagory) {
		// TODO Auto-generated method stub
		String ca;
//		switch(catagory) {
//		case 1: ca="bio";
//		case 2: ca="geo";
//		case 3: ca="reviews";
//		default: ca=null;
//		}
//		ca = "reverse";
		try {
			m.init();
			m.getCol(catagory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<QueryResult> getData(String[] query) {
		// TODO Auto-generated method stub
		List<QueryResult> qrs = new ArrayList<>();
		for(int i=0;i<query.length;i++) {
			Reverse r = m.query(query[i]);
			if(r!=null) {
				QueryResult qr = new QueryResult(r.getIdf(),r.getTf());
				qrs.add(qr);
			}
		}
		return qrs;
	}
	
	public void closeConn() {
		m.closeConn();
	}

}
