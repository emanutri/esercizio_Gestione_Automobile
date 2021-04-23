package it.gestioneautomobile.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestioneautomobile.dao.AutomobileDao;
import it.gestioneautomobile.model.Automobile;
import it.gestioneautomobile.web.listener.LocalEntityManagerFactoryListener;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDao automobileDao;

	@Override
	public void setAutomobileDao(AutomobileDao AUTOMOBILEDAO_INSTANCE) {
		this.automobileDao = AUTOMOBILEDAO_INSTANCE;
	}

	@Override
	public List<Automobile> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.findOne(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.update(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.insert(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Automobile automobileInstance) throws Exception {
		// questo è come una connection

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.delete(entityManager.merge(automobileInstance));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Automobile> findByExample(Automobile automobileInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.findByExample(automobileInstance);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
