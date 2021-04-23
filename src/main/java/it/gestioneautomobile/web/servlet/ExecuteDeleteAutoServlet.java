package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestioneautomobile.model.Automobile;
import it.gestioneautomobile.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteAutoServlet")
public class ExecuteDeleteAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteAutoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String IdAutoDaEliminare = request.getParameter("inputId");

		if (!NumberUtils.isCreatable(IdAutoDaEliminare)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/ricerca.jsp").forward(request, response);
			return;
		}
		try {

			Automobile autoDaEliminare = MyServiceFactory.getAutomobileServiceInstance()
					.caricaSingoloElemento(Long.parseLong(IdAutoDaEliminare));

			MyServiceFactory.getAutomobileServiceInstance().rimuovi(autoDaEliminare);

			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/ricerca.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

}
