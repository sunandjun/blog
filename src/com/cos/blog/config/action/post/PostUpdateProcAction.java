package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userId");
		String postId = request.getParameter("postId");
		String title =  request.getParameter("title");
		String content =  request.getParameter("content");
		String readCount =  request.getParameter("readCount");
		
		Post post = new Post(
				Integer.parseInt(postId),
				title,
				content,
				Integer.parseInt(readCount),
				null,
				Integer.parseInt(userId)
				);
		
		PostDao dao = new PostDao();
		int n = dao.글수정(post);
		
		response.sendRedirect("index.jsp");
		
	}

}
