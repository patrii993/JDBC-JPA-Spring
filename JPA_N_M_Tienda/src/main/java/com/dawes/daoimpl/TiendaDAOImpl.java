package com.dawes.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import com.dawes.dao.TiendaDAO;
import com.dawes.modelo.TiendaVO;

public class TiendaDAOImpl implements TiendaDAO {
	
	EntityManager em;
	
	public TiendaDAOImpl(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}

	public int insertar(TiendaVO tienda) {
		
		try {
			em.getTransaction().begin();
			em.persist(tienda);
			em.getTransaction().commit();
			return 1;
			
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				System.out.println("El nombre de la tienda ya existe." + e.getMessage() );
				em.getTransaction().rollback();
			}else {
				System.out.println("Error de persistencia " + e.getMessage());
				em.getTransaction().rollback();
			}	
			return 0;
		} catch (Exception e) {
			System.out.println("Error al insertar la tienda " + e.getMessage());
		}
		return 2;
	}

	public int modificar(TiendaVO tienda) {
		
		em.getTransaction().begin();
		em.merge(tienda);
		em.getTransaction().commit();
		return 1;
	}

	public int eliminar(TiendaVO tienda) {
		
		em.getTransaction().begin();
		em.remove(tienda);
		em.getTransaction().commit();
		return 1;
	}

	public Optional<TiendaVO> findByNombre(String nombre) {
		
		try {
			TypedQuery<TiendaVO> tiendas = em.createQuery("select t from TiendaVO t where nombre=?1", TiendaVO.class);
			tiendas.setParameter(1, nombre);
			return Optional.of(tiendas.getSingleResult());
		}catch (PersistenceException e) {
			if(e.getLocalizedMessage().equals("No entity found for query")) {
				System.out.println("Ese nombre no existe " + e.getMessage());
				return Optional.of(new TiendaVO());		
			}else {
				System.out.println("Error de persistencia " + e.getMessage());
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el método findByNombre " + e.getMessage());
			
		}
		return Optional.empty();
	}

	public Optional<List<TiendaVO>> findAll() {
		
		try {
			TypedQuery<TiendaVO> tiendas = em.createQuery("select t from TiendaVO t", TiendaVO.class);
			List<TiendaVO> lista = tiendas.getResultList();
			return Optional.of(lista);

		} catch (PersistenceException e) {
			System.out.println("Error de persistencia " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en el método findAll " + e.getMessage());
		}
		return Optional.empty();
	}

}
