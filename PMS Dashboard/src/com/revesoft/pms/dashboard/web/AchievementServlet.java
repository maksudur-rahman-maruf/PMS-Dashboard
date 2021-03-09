package com.revesoft.pms.dashboard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.revesoft.pms.dashboard.dao.AchievementDAO;
import com.revesoft.pms.dashboard.model.Achievement;

@WebServlet("/")
public class AchievementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Gson gson = new Gson();

	private AchievementDAO achievementDAO;

	public void init() {
		achievementDAO = new AchievementDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getServletPath());
		System.out.println(request.getContextPath());

		if (request.getServletPath().equals("/AchievementJsonData")) {
			try {
				AchievementJsonData(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		else {
			try {
				listAchievement(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void listAchievement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		int year = Integer.parseInt(request.getParameter("year"));

		List<Achievement> listAchievement = achievementDAO.selectAllAchievements(year);
		request.setAttribute("listAchievement", listAchievement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("achievement-list.jsp");
		dispatcher.forward(request, response);
	}

	private void AchievementJsonData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String name = request.getParameter("name");
		response.getWriter().print("Hello " + name + "!!");

		Achievement achievementobj = new Achievement("January", 50.00);
		Achievement achievementobj2 = new Achievement("February", 60.00);
		Achievement achievementobj3 = new Achievement("March", 70.00);

		List<Achievement> list = new ArrayList<Achievement>();
		list.add(achievementobj);
		list.add(achievementobj2);
		list.add(achievementobj3);

		JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("jarray", jarray);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(jarray);
		out.print(jarray);

		out.flush();

	}

}
