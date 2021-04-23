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

@WebServlet("/ExecuteModificaAutoServlet")
public class ExecuteModificaAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteModificaAutoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String idAutoDaModificare = request.getParameter("inputId");

		// estraggo input
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String cilindrataInputStringParam = request.getParameter("cilindrata");
		String dataImmatricolazioneStringParam = request.getParameter("dataImmatricolazione");

		Date dataImmatricolazioneParsed = UtilityAutomobileForm
				.parseDateImmatricolazioneFromString(dataImmatricolazioneStringParam);

		Automobile autoInstance = new Automobile();
		autoInstance.setId(Long.parseLong(idAutoDaModificare));

		if (!UtilityAutomobileForm.validateInput(marcaInputParam, modelloInputParam, cilindrataInputStringParam,
				dataImmatricolazioneStringParam) || dataImmatricolazioneParsed == null) {

			autoInstance.setMarca(marcaInputParam);
			autoInstance.setModello(modelloInputParam);
			if (!cilindrataInputStringParam.isEmpty()) {
				autoInstance.setCilindrata(Integer.parseInt(cilindrataInputStringParam));
			}
			autoInstance.setDataImmatricolazione(dataImmatricolazioneParsed);

			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.setAttribute("automobileDaModificare", autoInstance);
			request.getRequestDispatcher("/automobile/edit.jsp").forward(request, response);
			return;
		}
		try {

			autoInstance.setMarca(marcaInputParam);
			autoInstance.setModello(modelloInputParam);
			autoInstance.setCilindrata(Integer.parseInt(cilindrataInputStringParam));
			autoInstance.setDataImmatricolazione(dataImmatricolazioneParsed);

			MyServiceFactory.getAutomobileServiceInstance().aggiorna(autoInstance);

			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/ricerca.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

}
