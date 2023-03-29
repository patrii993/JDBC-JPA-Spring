package com.dawes.util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.dawes.modelo.ProductoVO;
import com.dawes.modelo.TiendaProductoVO;
import com.dawes.modelo.TiendaVO;
import com.dawes.servicios.ServicioProducto;
import com.dawes.servicios.ServicioProductoImpl;
import com.dawes.servicios.ServicioTienda;
import com.dawes.servicios.ServicioTiendaImpl;
import com.dawes.servicios.ServicioTiendaProducto;
import com.dawes.servicios.ServicioTiendaProductoImpl;

public class MultinacionalTest {
	static ServicioProducto sp= new ServicioProductoImpl();
	static ServicioTienda st= new ServicioTiendaImpl();
	static ServicioTiendaProducto stp = new ServicioTiendaProductoImpl();

	@Test
	public void test01() {
		TiendaVO t1=new TiendaVO("HyM", "Gijón", new ArrayList());
		st.insertar(t1);
		st.insertar(new TiendaVO("Gucci", "Gijón", new ArrayList()));
		assertEquals(0, st.insertar(new TiendaVO("HyM", "Oviedo", new ArrayList())));
	}
	
	
	@Test
	public void test02() {
		
		assertEquals(1, st.eliminar(st.findByNombre("HyM").get()));
	}
	
	@Test
	public void test03() {
		
		assertEquals(1, sp.insertar(new ProductoVO("Camiseta", "23FGR",12.4f, new ArrayList() )));
	}
	@Test
	public void test04() {
		
		assertEquals(1, stp.insertar(new TiendaProductoVO(st.findByNombre("Gucci").get(),sp.findById(1).get(), 12)));
	}
	
	
	@Test
	public void test05() {
		
		assertEquals(1, stp.findByTiendaProductoStock(sp.findById(1).get()).get().size());
		System.out.println(stp.findByTiendaProductoStock(sp.findById(1).get()).get());
	}
	
	@Test
	public void test06() {
		
		assertEquals(1, st.findAll().get().size());
	}
	
	@Test
	public void test07() {
		
		assertEquals(1, sp.findAll().get().size());
	}
	

}
