package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Servlet implementation class ForwordExampleServlet
 */
@WebServlet(urlPatterns = {"/forword","/param"}, initParams = {@WebInitParam(name = "driver",value ="com.jdbc.coucou")})


public class ForwordExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Log log = LogFactory.getLog(ForwordExampleServlet.class);
    private String driver;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwordExampleServlet() {
        super();
        log.debug("------------------forword-------------------");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		log.debug("------------------init-------------------");
		driver = config.getInitParameter("driver");
		log.debug("----------------------------> driver : " + driver);
	}
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		log.debug("------------------service-------------------" + req.getMethod());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.debug("----------------------doGet-----------------");
		String forword = request.getParameter("f");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/"+forword);
		dispatcher.forward(request, response);
		log.debug("---------------> forwordTo : " + forword);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
