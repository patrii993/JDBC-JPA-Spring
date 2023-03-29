package com.dawes.instituto;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestInstituto {

	static Instituto i = new Instituto();

	//Probar la conexion
	@Test
	public void test01() {
		assertNotNull(i.getCon());
	}

	@Test
	public void test02() {
		assertEquals(1, i.insertarCiclo(new Ciclo("2IFC303", "Desarrollo Aplicaciones Web")));;
	}

	@Test
	public void test03() {
		assertEquals(1, i.insertarProfesor(new Profesor("Charo", "111", LocalDate.of(2000, 3, 12))));;
	}

	@Test
	public void test04() {
//		Ciclo ciclo = new Ciclo("2IFC304", "Desarrollo Aplicaciones Multiplataformas");
//		Profesor profesor = new Profesor("Pepe", "222", LocalDate.of(2000, 3, 12));
//		int ciclonuevo = i.insertarCiclo(ciclo);
//		int profesorNuevo = i.insertarProfesor(profesor);
//		ciclo.setIdciclo(ciclonuevo);
//		profesor.setIdprofesor(profesorNuevo);
		Ciclo ciclo = i.findCicloByDencorta("2IFC303");
		Profesor profesor = i.findProfesorByNif("111");
		assertEquals(1, i.insertarProfesorCiclo(new ProfesorCiclo(profesor, ciclo, LocalDate.of(2000, 3, 12))));
	}
	@Test
	public void test05() {
		assertEquals(1, i.getCrudpc().findByCiclo(i.findCicloByDencorta("2IFC303")).size());
	}
	@Test
	public void test06() {
		assertEquals(1, i.getCrudpc().findAllCicloProfesor().size());
	}
	

}
