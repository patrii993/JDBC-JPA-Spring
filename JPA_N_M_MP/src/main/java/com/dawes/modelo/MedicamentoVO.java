package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="medicamentos", uniqueConstraints=@UniqueConstraint(columnNames="denominacion"))
public class MedicamentoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmedicamento;
	private String denominacion;
	private String fabricante;
	@OneToMany(mappedBy="medicamento")
	private List<PacienteMedicamentoVO> pacientes;
	
	public MedicamentoVO() {
		pacientes=new ArrayList();
	}

	public MedicamentoVO(int idmedicamento, String denominacion, String fabricante,
			List<PacienteMedicamentoVO> pacientes) {
		super();
		this.idmedicamento = idmedicamento;
		this.denominacion = denominacion;
		this.fabricante = fabricante;
		this.pacientes = pacientes;
	}

	public MedicamentoVO(String denominacion, String fabricante, List<PacienteMedicamentoVO> pacientes) {
		super();
		this.denominacion = denominacion;
		this.fabricante = fabricante;
		this.pacientes = pacientes;
	}

	public int getIdmedicamento() {
		return idmedicamento;
	}

	public void setIdmedicamento(int idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public List<PacienteMedicamentoVO> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteMedicamentoVO> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		return "MedicamentoVO [idmedicamento=" + idmedicamento + ", denominacion=" + denominacion + ", fabricante="
				+ fabricante + "]";
	}
	

}
