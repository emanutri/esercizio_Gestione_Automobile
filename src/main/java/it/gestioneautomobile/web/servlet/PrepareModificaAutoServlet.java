package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestioneautomobile.service.MyServiceFactory;

@WebServlet("/PrepareModificaAutoServlet")
public class PrepareModificaAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareModificaAutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String parametroIdAutoCheVoglioModificare = request.getParameter("idAutomobile");

		if (!NumberUtils.isCreatable(parametroIdAutoCheVoglioModificare)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/result.jsp").forward(request, response);
			return;
		}

		try {

			request.setAttribute("automobileDaModificare", MyServiceFactory.getAutomobileServiceInstance()
					.caricaSingoloElemento(Long.parseLong(parametroIdAutoCheVoglioModificare)));

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("automobile/result.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/automobile/edit.jsp").forward(request, response);
	}

}
