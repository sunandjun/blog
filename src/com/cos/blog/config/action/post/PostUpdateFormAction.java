package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String postId = request.getParameter("id");
		
		PostDao dao = new PostDao();
		Post post = dao.상세보기(postId);
		
		request.setAttribute("updatePost", post);
		
		RequestDispatcher rd = request.getRequestDispatcher("/post/updateForm.jsp");
		rd.forward(request, response);
		
	}

}
