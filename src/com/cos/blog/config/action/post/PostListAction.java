package com.cos.blog.config.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PostDao dao = new PostDao();
		List<Post> posts = dao.글목록();
		
		request.setAttribute("posts", posts);
		
		RequestDispatcher rd = request.getRequestDispatcher("/post/list.jsp");
		rd.forward(request, response);

	}
}
