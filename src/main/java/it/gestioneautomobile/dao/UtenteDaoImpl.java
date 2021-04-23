package it.gestioneautomobile.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestioneautomobile.model.Utente;

public class UtenteDaoImpl implements UtenteDao {

	private EntityManager entityManager;

	@Override
	public List<Utente> list() throws Exception {
		return entityManager.createQuery("from Utente", Utente.class).getResultList();
	}

	@Override
	public Utente findOne(Long id) throws Exception {
		return entityManager.find(Utente.class, id);
	}

	@Override
	public void update(Utente input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);

	}

	@Override
	public void insert(Utente input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(input);
	}

	@Override
	public void delete(Utente input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Utente loginUser(String usernameInput, String passwordInput) {
		TypedQuery<Utente> query = entityManager.createQuery("from Utente u where u.username=?1 and u.password =?2 and u.stato = 'ATTIVO'",
				Utente.class);
		query.setParameter(1, usernameInput);
		query.setParameter(2, passwordInput);
		return query.getResultStream().findFirst().orElse(null);
	}

}
