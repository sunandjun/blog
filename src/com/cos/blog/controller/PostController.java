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
import com.cos.blog.config.action.post.PostListAction;
import com.cos.blog.config.action.post.PostSaveFormAction;
import com.cos.blog.config.action.post.PostSaveProcAction;
import com.cos.blog.config.action.post.PostUpdateFormAction;
import com.cos.blog.config.action.post.PostUpdateProcAction;
import com.cos.blog.model.Post;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PostController() {
        super();
    }
    
    //http://localhost:8080/post/list.do
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("/post 요청됨");
		String cmd = request.getParameter("cmd");
		
		Action action = route(cmd);
		if(action != null)action.execute(request, response);
		
    }
    private Action route(String cmd) {
    	if(cmd.equals("list")) {
    		return new PostListAction();
    	}else if(cmd.equals("saveForm")) {
    		return new PostSaveFormAction();
    	}else if(cmd.equals("saveProc")) {
    		return new PostSaveProcAction();
    	}else if(cmd.equals("updateForm")) {
    		return new PostUpdateFormAction();
    	}else if(cmd.equals("updateProc")) {
    		return new PostUpdateProcAction();
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
