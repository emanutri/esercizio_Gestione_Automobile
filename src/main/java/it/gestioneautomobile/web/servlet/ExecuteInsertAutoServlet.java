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

@WebServlet("/ExecuteInsertAutoServlet")
public class ExecuteInsertAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAutoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("accesso_utente") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		// estraggo input
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String cilindrataInputStringParam = request.getParameter("cilindrata");
		String dataImmatricolazioneStringParam = request.getParameter("dataImmatricolazione");

		// questa variabile mi serve in quanto sfrutto in un colpo la validazione
		// della data ed il suo parsing che non posso fare senza un try catch
		// a questo punto lo incapsulo in un metodo apposito
		Date dataImmatricolazioneParsed = UtilityAutomobileForm
				.parseDateImmatricolazioneFromString(dataImmatricolazioneStringParam);

		Automobile autoInstance = new Automobile();

		// valido input tramite apposito metodo e se la validazione fallisce torno in
		// pagina
		if (!UtilityAutomobileForm.validateInput(marcaInputParam, modelloInputParam, cilindrataInputStringParam,
				dataImmatricolazioneStringParam) || dataImmatricolazioneParsed == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");

			autoInstance.setMarca(marcaInputParam);
			autoInstance.setModello(modelloInputParam);
			if (!cilindrataInputStringParam.isEmpty())
				autoInstance.setCilindrata(Integer.parseInt(cilindrataInputStringParam));
			autoInstance.setDataImmatricolazione(dataImmatricolazioneParsed);

			request.setAttribute("automobileDaInserire", autoInstance);

			request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
			return;
		}

		autoInstance.setMarca(marcaInputParam);
		autoInstance.setModello(modelloInputParam);
		autoInstance.setCilindrata(Integer.parseInt(cilindrataInputStringParam));
		autoInstance.setDataImmatricolazione(dataImmatricolazioneParsed);

		// occupiamoci delle operazioni di business
		try {
			autoInstance.setMarca(marcaInputParam);
			autoInstance.setModello(modelloInputParam);
			autoInstance.setCilindrata(Integer.parseInt(cilindrataInputStringParam));
			autoInstance.setDataImmatricolazione(dataImmatricolazioneParsed);

			MyServiceFactory.getAutomobileServiceInstance().inserisciNuovo(autoInstance);
			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

}
