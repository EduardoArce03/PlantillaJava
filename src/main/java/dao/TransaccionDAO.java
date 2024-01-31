package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Transaccion;

@Stateless
public class TransaccionDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Transaccion transaccion) {
		em.persist(transaccion);
	}
}
