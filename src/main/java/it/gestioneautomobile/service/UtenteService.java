package it.gestioneautomobile.service;

import java.util.List;

import it.gestioneautomobile.dao.UtenteDao;
import it.gestioneautomobile.model.Utente;

public interface UtenteService {

	public void setUtenteDao(UtenteDao UTENTEDAO_INSTANCE);

	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Utente utenteInstance) throws Exception;

	public void inserisciNuovo(Utente utenteInstance) throws Exception;

	public void rimuovi(Utente utenteInstance) throws Exception;

	public Utente accedi(String usernameInput, String passwordInput) throws Exception;

}
