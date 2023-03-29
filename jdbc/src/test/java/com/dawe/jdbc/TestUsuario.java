package com.dawe.jdbc;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.dawes.jdbc.CRUDUsuario;
import com.dawes.jdbc.Usuario;

public class TestUsuario {


	static CRUDUsuario c= new CRUDUsuario();
	
	
	@Test
	public void test1() {
		c.insertar(new Usuario("Jaime", 20, LocalDate.of(2000, 3, 12)));
		assertEquals(1, c.insertar(new Usuario("Pepa", 23, LocalDate.of(2000, 3, 12))));
		
	}
	
	@Test
	public void test2() {
		
		assertEquals(1,c.eliminar(c.findById(1)));
		
	}	
	
	@Test
	public void test3() {
		
		assertEquals(1,c.findAll().size());
		
	}
	
	@Test
	public void test4() {
		Usuario u=c.findById(1);
		u.setEdad(27);
		assertEquals(1,c.modificar(u));
	}

}
