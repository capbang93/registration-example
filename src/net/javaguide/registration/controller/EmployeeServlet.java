package net.javaguide.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguide.registration.dao.EmployeeDao;
import net.javaguide.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EmployeeDao employeeDao = new EmployeeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/* 요청정보 Body에 있는 문자열들을 인자값으로 지정한 문자코드로 인코딩한다. */ 
		request.setCharacterEncoding("UTF-8");

		/* 응답정보 문자열들을 인자값으로 지정한 문자코드로 인코딩한다. */ 
		response.setContentType("text/html;charset=UTF-8");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 요청정보 Body에 있는 문자열들을 인자값으로 지정한 문자코드로 인코딩한다. */ 
		request.setCharacterEncoding("UTF-8");

		/* 응답정보 문자열들을 인자값으로 지정한 문자코드로 인코딩한다. */ 
		response.setContentType("text/html;charset=UTF-8");


		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUserName(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
		try {
			employeeDao.registerEmployee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);
		
		/*
		response.sendRedirect("/WEB-INF/view/employeedetails.jsp");
		*/
	}

}
