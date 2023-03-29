package com.dawes.instituto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDProfesor {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;


	public CRUDProfesor(Connection con) {
		this.con = con;
	}

	public int insertar (Profesor profesor) {
		try {
			ps=con.prepareStatement("insert into profesores(nombre,nif,fecha) values(?,?,?)");
			ps.setString(1, profesor.getNombre());
			ps.setString(2, profesor.getNif());
			ps.setDate(3, Date.valueOf(profesor.getFecha()));//cuando escribimos valueof
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al insertar un profesor " + e.getMessage());
			return 0;
		}
	}

	public Profesor findByNif(String nif) {
		try {
			ps=con.prepareStatement("select * from profesores where nif=?");
			ps.setString(1, nif);
			rs= ps.executeQuery();
			if(rs.next()) {
				return new Profesor(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate());
			}
			return null;
		} catch (SQLException e) {
			System.out.println("Error al consultar nif " + e.getMessage());
			return null;
		}



	}
}
