package com.cos.blog.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.DBConn;
import com.cos.blog.config.action.Action;
import com.cos.blog.config.action.user.UserJoinFormAction;
import com.cos.blog.config.action.user.UserJoinProcAction;
import com.cos.blog.config.action.user.UserLoginFormAction;
import com.cos.blog.config.action.user.UserLoginProcAction;
import com.cos.blog.config.action.user.UserLogoutAction;
import com.cos.blog.config.action.user.UserUpdateFormAction;
import com.cos.blog.config.action.user.UserUpdateProcAction;
import com.cos.blog.model.Post;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserController() {
        super();
    }
    
    //http://localhost:8080/post/list.do
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/user 요청됨");
		String cmd = request.getParameter("cmd");
		
		Action action = route(cmd);
		if(action != null)action.execute(request, response);
		
   }
    
    private Action route(String cmd) {
    	if(cmd.equals("joinForm")) {
  			//회원가입 페이지 Redirect
  			return new UserJoinFormAction();
  		}else if(cmd.equals("loginForm")) {
  			//로그인 페이지 Redirect
  			return new UserLoginFormAction();
  		}else if(cmd.equals("updateForm")) {
  			//회원수정 페이지로 이동 Model로 이동 후 RequestDispatcher
  			return new UserUpdateFormAction();
  		}else if(cmd.equals("joinProc")) {
  			return new UserJoinProcAction();
  		}else if(cmd.equals("loginProc")) { 
  			return new UserLoginProcAction();
  		}else if(cmd.equals("updateProc")) {
  			//1. 회원수정 진행 (update) Model로 이동
  			//2. 메인 페이지 이동 Redirect
  			return new UserUpdateProcAction();
  		}else if(cmd.equals("logout")) {
  			return new UserLogoutAction();
  		}
    	return null;
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
