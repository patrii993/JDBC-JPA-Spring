package com.dawes.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

//Clase de mantenimiento siempre se pone CRUD 
public class CRUDUsuario {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 
	 */
	public CRUDUsuario() {
		conectar();
		reset();
	}

	public void conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/tema1", "root", "temporal");

		}

		catch (SQLException e) {
			System.out.println("Se ha producido un error " + e.getMessage());
		}
	}

	public int insertar(Usuario usuario) {

		try {
			ps = con.prepareStatement("insert into usuarios(nombre,edad) values(?,?)"); // El ? es un valor dinamico que
			// cambia segun inserta
			ps.setString(1, usuario.getNombre());
			ps.setInt(2, usuario.getEdad());
			ps.setDate(3, Date.valueOf(usuario.getFecha()));
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al insertar en usuario " + e.getMessage());
			return 0;
		}

	}

	// Inserccion masiva
	public int iserccionMasiva(HashSet<Usuario> usuarios) {
		int ret = 0;
		for (Usuario usuario : usuarios) {
			try {
				ps = con.prepareStatement("insert into usuarios(nombre,edad) VALUES(?,?)");
				ps.setString(1, usuario.getNombre());
				ps.setInt(2, usuario.getEdad());
				ret += ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al insertar en usuarios " + e.getMessage());
				return 0;
			}

		}
		return ret;
	}

	public void reset() {
		// eliminar todos registrosç
		try {
			ps = con.prepareStatement("delete from usuarios");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar usuarios registrados " + e.getMessage());
		}
		// poner la secuencia a 1
		try {
			ps = con.prepareStatement("alter table usuarios auto_increment = 0");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al poner la secuencia a 1 " + e.getMessage());
		}
	}

	//eliminar usuario por id
	public int eliminar(Usuario usuario) {
		try {
			ps = con.prepareStatement("delete from usuarios where idusuario=?");
			ps.setInt(1, usuario.getIdusuario());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar usuario " + e.getMessage());
			return 0;
		}
	}

	//buscar por id
	public Usuario findById(int idusuario) {
		try {
			ps = con.prepareStatement("select * from usuarios where idusuario=?");
			ps.setInt(1, idusuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate());
			}
			return null;
		} catch (SQLException e) {
			System.out.println("Error al metodo findById " + e.getMessage());
			return null;
		}
	}
	//BUSCAR TODOS LOS USUARIOS	
	public ArrayList<Usuario> findAll() {
		ArrayList<Usuario> consulta = new ArrayList();
		try {
			ps = con.prepareStatement("select * from usuarios");
			rs = ps.executeQuery();
			while (rs.next()) {
				consulta.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
			}
			return consulta;
		} catch (SQLException e) {
			System.out.println("Error al metodo findAll " + e.getMessage());
			return null;
		}
	}

	//Modificar usuario
	public int modificar (Usuario usuario) {
		try {
			ps=con.prepareStatement("update usuarios set nombre=?, edad=?, fecha=? where idusuario=?");
			ps.setString(1, usuario.getNombre());
			ps.setInt(2, usuario.getEdad());
			ps.setInt(4, usuario.getIdusuario());
			ps.setDate(3, Date.valueOf(usuario.getFecha()));
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al modificar el usuario " + e.getMessage());
			return 0;
		}

	}

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the ps
	 */
	public PreparedStatement getPs() {
		return ps;
	}

	/**
	 * @param ps the ps to set
	 */
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

}