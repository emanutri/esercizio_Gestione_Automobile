package it.gestioneautomobile.dao;

import java.util.List;

import it.gestioneautomobile.model.Automobile;

public interface AutomobileDao extends IBaseDao<Automobile> {

	public List<Automobile> findByExample(Automobile example) throws Exception;

}
