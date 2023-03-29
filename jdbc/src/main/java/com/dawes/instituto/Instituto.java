package com.dawes.instituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Instituto {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private CRUDCiclo crudciclo;
	private CRUDProfesor crudprofesor;
	private CRUDProfesorCiclo crudpc;

	public Connection getCon() {
		return con;
	}

	public Instituto() {
		conectar();
		crudciclo=new CRUDCiclo(con);
		crudprofesor = new CRUDProfesor(con);
		crudpc= new CRUDProfesorCiclo(con);
		reset();

	}

	public void conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/tema1", "root", "temporal");

		} catch (SQLException e) {
			System.out.println("se ha producido un error " + e.getMessage());
		}
	}
	//Para insertar el ciclo
	public int insertarCiclo(Ciclo ciclo) {
		return crudciclo.insertar(ciclo);
	}

	public int insertarProfesor(Profesor profesor) {
		return crudprofesor.insertar(profesor);
	}

	public int insertarProfesorCiclo(ProfesorCiclo pc) {
		return crudpc.insertar(pc);

	}

	public Profesor findProfesorByNif(String nif) {
		return crudprofesor.findByNif(nif);
	}
	public Ciclo findCicloByDencorta(String dencorta) {
		return crudciclo.findByDenCorta(dencorta);
	}
	public int asignarProfesor(ProfesorCiclo pc){
		pc.getProfesor().getCiclos().add(pc);
		pc.getCiclo().getProfesores().add(pc);
		return crudpc.insertar(pc);

	}
	
	public ArrayList<Listado> findAllProfesorCiclo () {
		return crudpc.findAllCicloProfesor();
	}

	public void reset() {
		try {
			ps=con.prepareStatement("delete from profesorciclo");
			ps.executeUpdate();
			ps=con.prepareStatement("delete from ciclos");
			ps.executeUpdate();
			ps=con.prepareStatement("delete from profesores");
			ps.executeUpdate();
			ps=con.prepareStatement("alter table ciclos auto_increment=0");
			ps.executeUpdate();
			ps=con.prepareStatement("alter table profesores auto_increment=0");
			ps.executeUpdate();
			ps=con.prepareStatement("alter table profesorciclo auto_increment=0");
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al resetear las tablas " + e.getMessage());
		}
	}
	public CRUDProfesorCiclo getCrudpc()
	{
		return crudpc;
	}
}

