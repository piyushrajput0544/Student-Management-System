import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie.*;
import java.sql.*;

public class MyMenuDemo extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
                
                 HttpSession session=request.getSession();
                     String s=(String) session.getAttribute("uname");
                if(s!=null)
                {
		out.println("<link rel='stylesheet' href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
                out.println("<div id='mymenu'><ul><li><a href='HomeDemo.html'>Home</a></li><li><a href='InsDemo01.html'>Insert</a></li><li><a href=\"SearchDemo01.html\">Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='DeleteDemo.html'>Delete</a></li><li><a href='UpdateDemo01.html'>Update</a></li><li>About</li><li>Contact</li><li><a href='LogoutDemo'>LogoutDemo</a></li></ul></div>");
		out.println("Welcome "+s);
                }
                
                else
                {                

                     out.println("Login First ");
                }
                
                out.println("</body>");
                out.println("</html>");
                out.close();
        }
}
                
