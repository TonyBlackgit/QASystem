package com.dao;

import java.util.List;

public interface IndexSearcher {
	boolean connectToDB(String catagory);
	List<QueryResult> getData(String[] query);
	void closeConn();
}
