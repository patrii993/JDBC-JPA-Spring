package com.dawes.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dawes.dao.ProductoDAO;
import com.dawes.modelo.ProductoVO;

public class ProductoDAOImpl implements ProductoDAO {
	
	EntityManager em;

	public ProductoDAOImpl(EntityManager em) {
		this.em=em;
	}

	public int insertar(ProductoVO producto) {
		
		try {
			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();
			return 1;//Devuelve 1 si inserta
			
		}catch (PersistenceException e) {
			System.out.println("Error de persistencia " + e.getMessage() );
			em.getTransaction().rollback();
			return 0;
			
		} catch (Exception e) {
			System.out.println("Error al insertar el producto " + e.getMessage());
			em.getTransaction().rollback();

		}
		return 2;//Si hay otro error nos devuelve 2
	}

	public int modificar(ProductoVO producto) {
		;
		em.getTransaction().begin();
		em.merge(producto);
		em.getTransaction().commit();
		return 1;
	}

	public int eliminar(ProductoVO producto) {
		
		em.getTransaction().begin();
		em.remove(producto);
		em.getTransaction().commit();
		
		return 1;
	}

	public Optional<ProductoVO> findById(int id) {
	
		try {
			TypedQuery<ProductoVO> prenda = em.createQuery("select p from ProductoVO p where idproducto=?1",
					ProductoVO.class);
			prenda.setParameter(1, id);
			return Optional.of(prenda.getSingleResult());
		} catch (PersistenceException e) {
			if (e.getLocalizedMessage().equals("No entity found for query")) {
				System.out.println("Esa id no existe" + e.getMessage());
				return Optional.of(new ProductoVO());

			} else {
				System.out.println("Error de persistencia " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error en el método findById" + e.getMessage());
		}
		return Optional.empty();
	}

	public Optional<List<ProductoVO>> findAll() {
		
		try {
			TypedQuery<ProductoVO> prenda = em.createQuery("select p from ProductoVO p", ProductoVO.class);
			List<ProductoVO> lista = prenda.getResultList();
			return Optional.of(lista);

		} catch (PersistenceException e) {
			System.out.println("Error de persistencia " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en el método findAll " + e.getMessage());
		}
		return Optional.empty();
	}

}
