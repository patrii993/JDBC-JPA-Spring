package com.dawes.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="pacientes",uniqueConstraints=@UniqueConstraint(columnNames="dni"))
public class PacienteVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpaciente;
	private String dni;
	private String nombre;
	private LocalDate fechanacimiento;
	@OneToMany(mappedBy="paciente", cascade=CascadeType.REMOVE)
	private List<PacienteMedicamentoVO> medicamentos;
	
	public PacienteVO() {
		medicamentos=new ArrayList();
	}


	/**
	 * @param idpaciente
	 * @param dni
	 * @param nombre
	 * @param fechanacimiento
	 * @param medicamentos
	 */
	public PacienteVO(int idpaciente, String dni, String nombre, LocalDate fechanacimiento,
			List<PacienteMedicamentoVO> medicamentos) {
		super();
		this.idpaciente = idpaciente;
		this.dni = dni;
		this.nombre = nombre;
		this.fechanacimiento = fechanacimiento;
		this.medicamentos = medicamentos;
	}
	
	/**
	 * @return the fechanacimiento
	 */
	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}


	/**
	 * @param fechanacimiento the fechanacimiento to set
	 */
	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	/**
	 * @param dni
	 * @param nombre
	 * @param fechanacimiento
	 * @param medicamentos
	 */
	public PacienteVO(String dni, String nombre, LocalDate fechanacimiento, List<PacienteMedicamentoVO> medicamentos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechanacimiento = fechanacimiento;
		this.medicamentos = medicamentos;
	}


	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PacienteMedicamentoVO> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<PacienteMedicamentoVO> medicamentos) {
		this.medicamentos = medicamentos;
	}


	@Override
	public String toString() {
		return "PacienteVO [idpaciente=" + idpaciente + ", dni=" + dni + ", nombre=" + nombre + ", fechanacimiento="
				+ fechanacimiento + "]";
	}

	

}
