package com.daoImpl;

import com.dao.Query;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;;

public class QueryImpl implements Query {
	private String q;
	public QueryImpl(String q) {
		this.q = q;
	}
	@Override
	public String[] callTokenizer() {
		// TODO Auto-generated method stub
		Result r = NlpAnalysis.parse(q);
		String[] tmp = new String[r.size()];
		for(int i=0;i<r.size();i++) {
			tmp[i] = r.get(i).getName();
		}
		return tmp;
	}
//	public static void main(String[] args) {
//		QueryImpl q = new QueryImpl("黄褐色隶属于");
//		String[] strs = q.callTokenizer();
//		for(String str:strs)
//			System.out.println(str);
//	}
}
