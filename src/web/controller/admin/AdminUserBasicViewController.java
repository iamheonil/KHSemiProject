package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminUserBasicSearchController
 */
@WebServlet("/admin/userbasic/view")
public class AdminUserBasicViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/dept/view.jsp").forward(req, resp);

	}

}
