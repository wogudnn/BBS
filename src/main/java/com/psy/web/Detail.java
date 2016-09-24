package com.psy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.biz.BBSBiz;
import com.psy.biz.BBSBizImpl;
import com.psy.vo.BulletinBoardSystemVO;

public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BBSBiz biz;
    public Detail() {
        super();
        biz = new BBSBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String IdParam = request.getParameter("Id");
		if(IdParam==null) {
			IdParam = "0";
		}
		int Id = Integer.parseInt(IdParam);
		BulletinBoardSystemVO boardSystemVO = biz.getPosting(Id);
		String viewPath = "WEB-INF/view/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("boardSystemVO", boardSystemVO);
		
		rd.forward(request, response);
		
		
	}

	
}
