package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.*;
import com.dao.*;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String query = request.getParameter("query");
		String catagory = request.getParameter("catagory");
		
		Query q = new QueryImpl(query);
		String[] strs = q.callTokenizer();
		
		IndexSearcher is = new IndexSearcherImpl();
		List<QueryResult> qrs = null;
		if(is.connectToDB(catagory))
			qrs = is.getData(strs); 
		else {
			request.setAttribute("message", "连接数据库出错");
			request.getRequestDispatcher("false.jsp").forward(request, response);
		}
		is.closeConn();
		
		TopDocsCollector tdc = new TopDocsCollectorImpl();
		List<String> ids = null;
		ids = tdc.sort(qrs);
		List<String> titles = null;
		titles = tdc.findTitle(ids, catagory);
		
		request.setAttribute("titles", titles);
		request.setAttribute("ids", ids);
		request.setAttribute("catagory", catagory);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

}
