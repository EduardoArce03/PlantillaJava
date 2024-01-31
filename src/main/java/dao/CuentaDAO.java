package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Cuenta;

@Stateless
public class CuentaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cuenta cuenta) {
		em.persist(cuenta);
	}
	
	public void update(Cuenta cuenta) {
		em.merge(cuenta);
	}
	public Cuenta read(int numCuenta) {
		return em.find(Cuenta.class, numCuenta);
	}
	public List<Cuenta> getAll(){
		String jpql = "SELECT c FROM Cuenta c";
		Query q = em.createQuery(jpql, Cuenta.class);
		return q.getResultList();
	}
	
}
