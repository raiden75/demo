package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */

//@Web
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title> Infos Servlet </title></head>");
		out.println("<body>");
		
		String requestUrl = request.getRequestURL().toString();
		out.println("<br><span>requestUrl :"+requestUrl);
		out.println("</span>");
		
		String requestUri = request.getRequestURI().toString();
		out.println("<br><span>requestUri :"+requestUri);
		out.println("</span>");
		
		String contextPath = request.getContextPath().toString();
		out.println("<br><span>contextPath :"+contextPath);
		out.println("</span>");
		
		// Header Infos :
		
		out.println("<br><br><b>Headers :</b>");
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			out.println("<br> "+header+" : "+request.getHeader(header));

		}
		
		// Emplacement de l'application web sur le Disque Dur :
		
		out.println("<br><br><b>Real path :</b> ");
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("");
		
		out.println(realPath);
		
		out.println("</body>");
		
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Infos Servlet</title><head>");
		out.println("<h1>Method Post</h1>");
		String login = request.getParameter("Login");
		String pass = request.getParameter("Password");
		out.println("<h1> Method Post : login = " + login + " | password = " + pass);
	}

}
