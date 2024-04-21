import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateDemo1 extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
                out.println("<center>");
                out.println("<form action='UpdateDemo2'>");
                
                out.println("<table cellpadding='20' border='1'>");
               
		
		String s1=request.getParameter("ur");
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava77?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks where urno='"+s1+"' ");
			
			if(rs.next())
                        {
                       
out.println("<tr>");
out.println("<td>Enter Rno</td>");
out.println("<td><input type='text' value='"+rs.getString(1)+"'placeholder='Eneter Name' name='ur' class='A'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>Enter Name</td>");
out.println("<td><input type='text' value='"+rs.getString(2)+"'placeholder='Eneter Name' name='un' class='A'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>Enter PHY</td>");
out.println("<td><input type='text' value='"+rs.getString(3)+"'placeholder='Eneter PHY' name='up' class='A'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>Enter CHEM</td>");
out.println("<td><input type='text' value='"+rs.getString(4)+"'placeholder='Eneter CHEM' name='uc' class='A'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>Enter MATHS</td>");
out.println("<td><input type='text' value='"+rs.getString(5)+"'placeholder='Eneter MATHS' name='um' class='A'></td>");
out.println("</tr>");



out.println("<tr>");
out.println("<th colspan='2'><input type='submit' class='B' value='Update'></th>");
out.println("</tr>");

			}
                        
                        else
	{
		out.println("Invalid URO.");
	}
			out.println("</table>");
	                 con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
                 out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
	
}
