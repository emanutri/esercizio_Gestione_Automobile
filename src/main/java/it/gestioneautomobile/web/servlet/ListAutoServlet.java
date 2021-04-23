package it.gestioneautomobile.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestioneautomobile.model.Automobile;
import it.gestioneautomobile.service.MyServiceFactory;
import it.gestioneautomobile.utility.UtilityAutomobileForm;

@WebServlet("/ListAutoServlet")
public class ListAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListAutoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String cilindrataInputStringParam = request.getParameter("cilindrata");
		String dataImmatricolazioneStringParam = request.getParameter("dataImmatricolazione");

		Date dataImmatricolazioneParsed = UtilityAutomobileForm
				.parseDateImmatricolazioneFromString(dataImmatricolazioneStringParam);
		Automobile autoInstance = new Automobile();

		try {

			autoInstance.setMarca(marcaInputParam);
			autoInstance.setModello(modelloInputParam);
			if (cilindrataInputStringParam!= null && !cilindrataInputStringParam.isEmpty()) {
				autoInstance.setCilindrata(Integer.parseInt(cilindrataInputStringParam));
			}
			autoInstance.setDataImmatricolazione(dataImmatricolazioneParsed);

			request.setAttribute("listaAutomobiliAttribute",
					MyServiceFactory.getAutomobileServiceInstance().findByExample(autoInstance));
		} catch (Exception e) {

			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("automobile/ricerca.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

}
