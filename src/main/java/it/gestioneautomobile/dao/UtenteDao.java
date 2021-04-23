package it.gestioneautomobile.dao;

import it.gestioneautomobile.model.Utente;

public interface UtenteDao extends IBaseDao<Utente> {

	public Utente loginUser(String usernameInput, String passwordInput);

}
