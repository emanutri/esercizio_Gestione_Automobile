package it.gestioneautomobile.service;

import java.util.List;

import it.gestioneautomobile.dao.AutomobileDao;
import it.gestioneautomobile.model.Automobile;

public interface AutomobileService {

	public void setAutomobileDao(AutomobileDao AUTOMOBILEDAO_INSTANCE);

	public List<Automobile> listAll() throws Exception;

	public Automobile caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Automobile automobileInstance) throws Exception;

	public List<Automobile> findByExample(Automobile automobileInstance) throws Exception;
}
