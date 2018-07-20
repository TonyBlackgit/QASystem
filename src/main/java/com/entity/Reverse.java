package com.entity;

import java.util.HashMap;

import org.bson.types.ObjectId;

public class Reverse {
	private ObjectId id;
    private String key;
    private double idf;
    private HashMap<String,Double> tf;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getIdf() {
		return idf;
	}
	public void setIdf(double idf) {
		this.idf = idf;
	}
	public HashMap<String, Double> getTf() {
		return tf;
	}
	public void setTf(HashMap<String, Double> tf) {
		this.tf = tf;
	}
}
