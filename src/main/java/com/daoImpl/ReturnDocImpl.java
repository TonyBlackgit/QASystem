package com.daoImpl;

import com.dao.ReturnDoc;
import com.util.MysqlConn;

public class ReturnDocImpl implements ReturnDoc {

	@Override
	public String[] getData(String ca, String id) {
		// TODO Auto-generated method stub
		MysqlConn mc = new MysqlConn();
		mc.init();
		String[] detail = mc.queryDetail(ca, id);
		return detail;
	}

}
