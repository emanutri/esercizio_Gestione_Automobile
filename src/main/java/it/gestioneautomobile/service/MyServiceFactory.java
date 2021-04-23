package it.gestioneautomobile.service;

import it.gestioneautomobile.dao.AutomobileDao;
import it.gestioneautomobile.dao.AutomobileDaoImpl;
import it.gestioneautomobile.dao.UtenteDao;
import it.gestioneautomobile.dao.UtenteDaoImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static AutomobileService AUTOMOBILE_SERVICE_INSTANCE = null;
	private static AutomobileDao AUTOMOBILEDAO_INSTANCE = null;

	private static UtenteService UTENTE_SERVICE_INSTANCE = null;
	private static UtenteDao UTENTEDAO_INSTANCE = null;

	public static AutomobileService getAutomobileServiceInstance() {
		if (AUTOMOBILE_SERVICE_INSTANCE == null)
			AUTOMOBILE_SERVICE_INSTANCE = new AutomobileServiceImpl();

		if (AUTOMOBILEDAO_INSTANCE == null)
			AUTOMOBILEDAO_INSTANCE = new AutomobileDaoImpl();

		AUTOMOBILE_SERVICE_INSTANCE.setAutomobileDao(AUTOMOBILEDAO_INSTANCE);

		return AUTOMOBILE_SERVICE_INSTANCE;
	}

	public static UtenteService getUtenteServiceInstance() {
		if (UTENTE_SERVICE_INSTANCE == null)
			UTENTE_SERVICE_INSTANCE = new UtenteServiceImpl();

		if (UTENTEDAO_INSTANCE == null)
			UTENTEDAO_INSTANCE = new UtenteDaoImpl();

		UTENTE_SERVICE_INSTANCE.setUtenteDao(UTENTEDAO_INSTANCE);

		return UTENTE_SERVICE_INSTANCE;
	}

}
