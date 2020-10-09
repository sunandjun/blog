package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("email"),
				request.getParameter("address")
				);
		
		UserDao userDao = new UserDao();
		userDao.회원수정(user);
		
		
		response.sendRedirect("/post/list.jsp");
	}	
}
