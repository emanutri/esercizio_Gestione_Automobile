package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestioneautomobile.service.MyServiceFactory;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usernameParameter = request.getParameter("inputUsername");
		String passwordParameter = request.getParameter("inputPassword");

		if (usernameParameter == null || passwordParameter == null || usernameParameter.equals("")
				|| passwordParameter.equals("")) {

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		try {
			request.getSession().setAttribute("accesso_utente",
					MyServiceFactory.getUtenteServiceInstance().accedi(usernameParameter, passwordParameter));

		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/automobile/ricerca.jsp").forward(request, response);

	}

}
