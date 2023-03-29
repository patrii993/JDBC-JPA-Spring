package com.dawes.instituto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.dawes.jdbc.Usuario;

public class CRUDProfesorCiclo {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CRUDProfesorCiclo(Connection con) {
		this.con = con;
	}

	public int insertar(ProfesorCiclo pc) {
		try {
			ps = con.prepareStatement("insert into profesorCiclo(idprofesor, idciclo, fecha) values(?,?,?)");
			ps.setInt(1, pc.getProfesor().getIdprofesor());
			ps.setInt(2, pc.getCiclo().getIdciclo());
			ps.setDate(3, Date.valueOf(pc.getFecha()));// cuando escribimos valueof
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al insertar un profesor " + e.getMessage());
			return 0;
		}
	}

	public ArrayList<Ciclo> findByProfesor(Profesor profesor) {
		ArrayList<Ciclo> ciclos = new ArrayList();
		try {
			ps = con.prepareStatement(
					"select ciclos.* from profesorciclo,ciclos where profesorciclo.idprofesor=? and profesorciclo.idciclo=ciclos.idciclo");
			ps.setInt(1, profesor.getIdprofesor());
			rs = ps.executeQuery();
			while (rs.next()) {

				ciclos.add(new Ciclo(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return ciclos;
		} catch (SQLException e) {
			System.out.println("Error en el metodo  findByProfesor" + e.getMessage());
			return null;
		}
	}

	public ArrayList<Profesor> findByCiclo(Ciclo ciclo) {
		ArrayList<Profesor> profesores = new ArrayList();
		try {
			ps = con.prepareStatement(
					"select profesores.* from profesorciclo, profesores where profesorciclo.idprofesor=profesores.idprofesor and profesorciclo.idciclo=?");
			ps.setInt(1, ciclo.getIdciclo());
			rs = ps.executeQuery();
			while (rs.next()) {

				profesores.add(new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate()));
			}
			return profesores;
		} catch (SQLException e) {
			System.out.println("Error en el metodo findByCiclo " + e.getMessage());
			return null;
		}

	}
	
	public ArrayList< Listado> findAllCicloProfesor(){
		ArrayList<Listado> listado=new ArrayList();
		try {
		ps=con.prepareStatement("select * from profesorciclo, profesores, ciclos where profesorciclo.idprofesor=profesores.idprofesor and profesorciclo.idciclo=ciclos.idciclo order by ciclos.dencorta");
		rs=ps.executeQuery();
		while(rs.next()){
			listado.add(new Listado(rs.getString("ciclos.dencorta"), rs.getString("profesores.nombre")));
		}
		return listado;
		} catch (SQLException e) {
			System.out.println("Error en el metodo findAllCicloProfesor " + e.getMessage());
			return null;
		}
		
	}
	
	public ArrayList<Profesor> findProfesorAntiguo(ProfesorCiclo pc){
		ArrayList<Profesor> lista=new ArrayList();
		try {
			ps = con.prepareStatement("select nombre from profesorciclo,profesores where fecha and profesorciclo.idprofesor=profesores.idprofesor");
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Error en el metodo findProfesorAntiguo " + e.getMessage());
			return null;
		}
		
		
	}

}
