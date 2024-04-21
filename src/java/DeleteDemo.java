import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteDemo extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
                String s1=request.getParameter("ur");
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava77?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("Delete from insmarks where urno='"+s1+"'");
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

