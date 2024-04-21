import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisDemo extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava77?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into login values('"+s1+"','"+s2+"')");
			response.sendRedirect("Login01.html");
			con.close();
			
			
		}
		catch(Exception e1)
		{
			
			System.out.println(e1);
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}
	
	
}

