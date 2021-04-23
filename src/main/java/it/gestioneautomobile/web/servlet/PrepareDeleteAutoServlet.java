package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestioneautomobile.service.MyServiceFactory;

@WebServlet("/PrepareDeleteAutoServlet")
public class PrepareDeleteAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteAutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String parametroIdAutoCheVoglioEliminare = request.getParameter("idAutomobile");

		if (!NumberUtils.isCreatable(parametroIdAutoCheVoglioEliminare)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore!");
			request.getRequestDispatcher("/automobile/ricerca.jsp").forward(request, response);
			return;
		}
		try {

			request.setAttribute("automobileDaEliminare", MyServiceFactory.getAutomobileServiceInstance()
					.caricaSingoloElemento(Long.parseLong(parametroIdAutoCheVoglioEliminare)));

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/ricerca.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/automobile/delete.jsp").forward(request, response);
	}

}
