import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie.*;


public class LogoutDemo extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		 HttpSession session=request.getSession();
                        session.invalidate();
                response.sendRedirect("Login01.html");
		
		
	}
	
	
}
