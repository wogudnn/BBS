package com.psy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.biz.BBSBiz;
import com.psy.biz.BBSBizImpl;
import com.psy.vo.BulletinBoardSystemVO;

public class DoWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BBSBiz biz;
       
    public DoWrite() {
        super();
        biz = new BBSBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String creator = request.getParameter("creator");
		
		BulletinBoardSystemVO boardSystemVO = new BulletinBoardSystemVO();
		boardSystemVO.setTitle(title);
		boardSystemVO.setContents(contents);
		boardSystemVO.setCreatorName(creator);
		
		biz.addPosting(boardSystemVO);
		
		response.sendRedirect("/BBS/list");
		
		
	}

}
