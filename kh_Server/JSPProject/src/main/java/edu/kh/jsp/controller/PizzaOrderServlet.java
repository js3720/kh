package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pizzaOrder")
public class PizzaOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 얻어오기
		String pizza = req.getParameter("pizza");
		String size = req.getParameter("size");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		int result = (10000 + (size.equals("L") ? 2000 : 0))*amount;
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp");
		req.setAttribute("res", result);
		req.setAttribute("pizza", pizza);
		req.setAttribute("size", size);
		req.setAttribute("amount", amount);
		dispatcher.forward(req, resp);
	}

}
