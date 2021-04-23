package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestioneautomobile.model.Automobile;

@WebServlet("/PrepareInsertAutoServlet")
public class PrepareInsertAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareInsertAutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		request.setAttribute("automobileDaInserire", new Automobile());

		request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
	}

}
