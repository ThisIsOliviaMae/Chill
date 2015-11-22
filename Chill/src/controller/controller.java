package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Classes.Province;
import Classes.Region;
import Classes.Scholarship;
import Classes.School;
import Manager.Manager;

/**
 * Servlet implementation class controller
 */
@WebServlet(urlPatterns = {"/controller", "/StartServlet", "/ToSchoolList",
		"/ToSchoolInfo", "/ToScholarships", "/FromSchoolList", "/FromSchoolInfo",
		"/FromScholarships"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	protected void process(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Region> region;
		ArrayList<School> school;
		ArrayList<Province> province;
		ArrayList<Scholarship> scho;
		
		Manager manager;
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		switch (request.getServletPath()) {
		case "/StartServlet":
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			break;
			
		case "/ToSchoolInfo":
			school = (ArrayList<School>) request.getSession().getAttribute(
					"s");
			int index = Integer.parseInt(request.getParameter("index"));
			request.getSession().setAttribute("indexed", school.get(index));
			
			request.getRequestDispatcher("SchoolsInfo.jsp").forward(
					request, response);
			break;
		case "/ToSchoolList":
			region = new ArrayList<Region>();
			province = new ArrayList<Province>();
			manager = new Manager();
			region = manager.getAllRegions();
			province = manager.getAllProvinces();
			school = manager.getAllSchools();
			
			request.getSession().setAttribute("r", region);
			request.getSession().setAttribute("p", province);
			request.getSession().setAttribute("s", school);
			
			request.getRequestDispatcher("SchoolsList.jsp")
			.forward(request, response);
			break;
		
		
		case "/ToScholarships":
			//request.removeAttribute(region);
			manager = new Manager();
			scho = manager.getAllScholarships();/*
			request.getSession().removeAttribute("r");
			request.getSession().removeAttribute("p");
			request.getSession().removeAttribute("s");*/
			request.getSession().setAttribute("sc", scho);
			
			request.getRequestDispatcher("ScholarshipList.jsp")
			.forward(request, response);
			break;
		
		}
		
	}
	

}
