package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostSaveProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		
		//본문은 썸머노트가 알아서 해주지만 타이틀은 아니라서 우리가 벨리데이션 체크를 해주어야 한다.
		//다양한 검증을 해야 하지만 여기선 이것만..
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		
		Post post = new Post(
				title,
				request.getParameter("content"),
				0,
				Integer.parseInt(request.getParameter("userId")));
		
		PostDao dao = new PostDao();
		int n = dao.글쓰기(post);
		
		if(n == 1) {
			response.sendRedirect("index.jsp");
		}
		
		
		
	}

}
