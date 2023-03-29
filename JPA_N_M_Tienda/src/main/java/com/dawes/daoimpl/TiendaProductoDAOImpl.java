package com.dawes.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.exception.ConstraintViolationException;
import com.dawes.dao.TiendaProductoDAO;
import com.dawes.modelo.ProductoVO;
import com.dawes.modelo.TiendaProductoVO;

public class TiendaProductoDAOImpl implements TiendaProductoDAO {
	
	EntityManager em;
	public TiendaProductoDAOImpl(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}

	public int insertar(TiendaProductoVO tp) {
	
		try {
			em.getTransaction().begin();
			em.persist(tp);
			em.getTransaction().commit();
			return 1;
			
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				System.out.println("El nombre de la tienda a la que intentas asignar el producto ya existe." + e.getMessage() );
				em.getTransaction().rollback();
			}else {
				System.out.println("Error de persistencia " + e.getLocalizedMessage());
				em.getTransaction().rollback();
			}	
		}catch (Exception e) {
			System.out.println("Error al insertar tiendaproducto " + e.getMessage());
			em.getTransaction().rollback();
		}
		return 2;
		
	}

	public int modificar(TiendaProductoVO tp) {

		em.getTransaction().begin();
		em.merge(tp);
		em.getTransaction().commit();
		return 1;
	}

	public int elminar(TiendaProductoVO tp) {

		em.getTransaction().begin();
		em.remove(tp);
		em.getTransaction().commit();
		return 1;
	}

	public Optional<List<TiendaProductoVO>> findByTiendaProductoStock(ProductoVO producto) {
		
		try {

			TypedQuery<TiendaProductoVO> stockaje1 = em.createQuery(
					"select tp from TiendaProductoVO tp, ProductoVO p where tp.producto=?1 AND tp.stock>0",TiendaProductoVO.class);
			stockaje1.setParameter(1, producto);
			List<TiendaProductoVO> lista = stockaje1.getResultList();
			return Optional.of(lista);

		} catch (PersistenceException e) {
			System.out.println("Error de persistencia " + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("Error en el método findAll " + e.getLocalizedMessage());
		}
		return Optional.empty();
	}

}
