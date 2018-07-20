package com.dao;

import java.util.HashMap;

public class QueryResult {
	private double idf;
	private HashMap<String, Double> hm;

	public QueryResult(double idf, HashMap<String, Double> hm) {
		this.idf = idf;
		this.hm = hm;
	}

	public HashMap<String, Double> tfidf() {
		hm.forEach((k,v)->{
			hm.replace(k, v*idf);
		});
		return hm;
	}
}
