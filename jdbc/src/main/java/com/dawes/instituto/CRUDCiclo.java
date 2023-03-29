package com.dawes.instituto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDCiclo {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	public CRUDCiclo(Connection con) {
		this.con=con;
	}

	public int insertar(Ciclo ciclo) {
		try {
			ps = con.prepareStatement("insert into ciclos(dencorta, denlarga) values(?,?)");
			ps.setString(1, ciclo.getDencorta());
			ps.setString(2, ciclo.getDenlarga());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("se ha producido un error " + e.getMessage());
			return 0;
		}
	}

	public Ciclo findByDenCorta(String dencorta) {
		try {
			ps=con.prepareStatement("select * from ciclos where dencorta=?");
			ps.setString(1, dencorta);
			rs=ps.executeQuery();
			if(rs.next()) {
				return new Ciclo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			return null;
		} catch (SQLException e) {
			System.out.println("Error al consultar dencorta " + e.getMessage());
			return null;
		}

	}

}
