import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginDemo1 extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava77?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from login where uname='"+s1+"' AND upass='"+s2+"'");
			
			if(rs.next())
                        {
//                            Cookie ck=new Cookie("uname","Ritik");
//                            ck.setMaxAge(60*60);
//                            response.addCookie(ck);
                            HttpSession session=request.getSession();
                        session.setAttribute("uname",s1);
				response.sendRedirect("MyMenuDemo");
			}
			else
			{
			out.println("<center>");
			out.println("INVALID User Name And PassWord");
			out.println("</center>");
				
			}
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


