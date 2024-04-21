import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InsDemo extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		String s1=request.getParameter("ur");
		String s2=request.getParameter("un");
		String s3=request.getParameter("up");
		String s4=request.getParameter("uc");
		String s5=request.getParameter("um");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava77?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into insmarks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			response.sendRedirect("ShowAll");
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

