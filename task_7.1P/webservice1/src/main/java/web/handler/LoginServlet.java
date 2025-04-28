package web.handler;

import web.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet to handle login requests.
 * It checks username, password, and dob and returns a success or fail page.
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");

		boolean loginResult = LoginService.login(username, password, dob);

		if (loginResult) {
			response.getWriter().println("<html><head><title>success</title></head><body>Login Successful</body></html>");
		} else {
			response.getWriter().println("<html><head><title>fail</title></head><body>Login Failed</body></html>");
		}
	}
}