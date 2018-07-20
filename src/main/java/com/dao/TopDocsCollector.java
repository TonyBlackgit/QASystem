package com.dao;

import java.util.*;

public interface TopDocsCollector {
	List<String> sort(List<QueryResult> lists);
	List<String> findTitle(List<String> ids, String catagory);
}
