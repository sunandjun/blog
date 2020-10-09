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

public class UserUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("principal"); 
		
		UserDao dao = new UserDao();
		User responseUser = dao.회원정보읽기(user);
		
		request.setAttribute("userData", responseUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/updateForm.jsp");
		rd.forward(request, response);
			
		//response.sendRedirect("/user/updateForm.jsp");
	}
	
}
