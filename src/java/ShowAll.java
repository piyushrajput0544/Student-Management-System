import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ShowAll extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div id='mymenu'><ul><li><a href='HomeDemo.html'>Home</a></li><li><a href='InsDemo01.html'>Insert</a></li><li><a href=\"SearchDemo01.html\">Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='DeleteDemo.html'>Delete</a></li><li><a href='UpdateDemo01.html'>Update</a></li><li>About</li><li>Contact</li></ul></div>");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava77?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks");
			out.println("<center>");
			out.println("<table cellpadding='12' border=1>");
			out.println("<tr>");
			out.println("<th>RNO</th>");
			out.println("<th>Name</th>");
			out.println("<th>Phy</th>");
			out.println("<th>Chem</th>");
			out.println("<th>Maths</th>");
			out.println("</tr>");
			
			
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				
			}
			
			out.println("</table>");
			out.println("</center");
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
