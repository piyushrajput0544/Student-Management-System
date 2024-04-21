import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchDemo extends HttpServlet
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
                        out.println("<th>RNO.</th>");
                        out.println("<th>" + rs.getString(1) + "</th>");
                        out.println("</tr>");

                        out.println("<tr>"); 
                        out.println("<th>NAME</th>");
                        out.println("<th>" + rs.getString(2) + "</th>");
                        out.println("</tr>");
                         
                        out.println("<tr>"); 
                        out.println("<th>PHY</th>");
                        out.println("<th>" + rs.getString(3) + "</th>");
                        out.println("</tr>");

                        out.println("<tr>"); 
                        out.println("<th>CHEM</th>");
                        out.println("<th>" + rs.getString(4) + "</th>");
                        out.println("</tr>");
                        
                        out.println("<tr>"); 
                        out.println("<th>MATHS</th>");
                        out.println("<th>" + rs.getString(5) + "</th>");
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
