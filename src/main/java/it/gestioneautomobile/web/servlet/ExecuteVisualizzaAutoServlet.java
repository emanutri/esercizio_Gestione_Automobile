package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestioneautomobile.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaAutoServlet")
public class ExecuteVisualizzaAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteVisualizzaAutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String idAutomobileParam = request.getParameter("idAutomobile");

		if (!NumberUtils.isCreatable(idAutomobileParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
			return;
		}
		try {
			request.setAttribute("visualizza_automobile_attr", MyServiceFactory.getAutomobileServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idAutomobileParam)));

		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/automobile/show.jsp").forward(request, response);
	}

}
