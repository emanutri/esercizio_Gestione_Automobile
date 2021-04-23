package it.gestioneautomobile.dao;

public class MyDaoFactory {

	private static UtenteDao utenteDaoInstance = null;
	private static AutomobileDao libroDaoInstance = null;

	public static UtenteDao getUtenteDaoInstance() {
		if (utenteDaoInstance == null)
			utenteDaoInstance = new UtenteDaoImpl();

		return utenteDaoInstance;
	}

	public static AutomobileDao getAutomobileDaoInstance() {
		if (libroDaoInstance == null)
			libroDaoInstance = new AutomobileDaoImpl();

		return libroDaoInstance;
	}

}
