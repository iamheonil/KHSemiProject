package web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.User_basicService;
import web.service.face.User_detailService;
import web.service.impl.User_basicServiceImpl;
import web.service.impl.User_detailServiceImpl;

@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_basicService user_basicService = new User_basicServiceImpl();
	private User_detailService user_detailService = new User_detailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
}