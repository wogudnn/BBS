package com.psy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.biz.BBSBiz;
import com.psy.biz.BBSBizImpl;
import com.psy.vo.BulletinBoardSystemVO;


public class PostingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BBSBiz biz;
    
    public PostingList() {
        super();
        biz = new BBSBizImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BulletinBoardSystemVO> boardSystems = biz.getAllPosting();
		
		
		String viewPath = "WEB-INF/view/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("boardSystems", boardSystems);
		
		rd.forward(request, response);
	}

}
