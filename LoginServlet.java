package fit.iuh.tuan01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        ServletContext context = getServletContext();
        String correctUsername = context.getInitParameter("username");
        String correctPassword = context.getInitParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            response.getWriter().println("<h1>Hello " + context.getInitParameter("name") + "</h1>");
        } else {
            response.getWriter().println("<h1>Đăng nhập thất bại</h1><br><a href='login.html'>Quay về trang trước</a>");
        }
        
        out.println();
                
	}

}
