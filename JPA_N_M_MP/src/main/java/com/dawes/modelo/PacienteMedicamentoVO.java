package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pacientemedicamento")
public class PacienteMedicamentoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpm;
	@ManyToOne
	private MedicamentoVO medicamento;
	@ManyToOne
	private PacienteVO paciente;
	private LocalDate fecha;
	private float dosis;
	private String unidadmedida;
	
	public PacienteMedicamentoVO() {
		// TODO Auto-generated constructor stub
	}

	public PacienteMedicamentoVO(int idpm, MedicamentoVO medicamento, PacienteVO paciente, LocalDate fecha, float dosis,
			String unidadmedida) {
		super();
		this.idpm = idpm;
		this.medicamento = medicamento;
		this.paciente = paciente;
		this.fecha = fecha;
		this.dosis = dosis;
		this.unidadmedida = unidadmedida;
	}

	public PacienteMedicamentoVO(MedicamentoVO medicamento, PacienteVO paciente, LocalDate fecha, float dosis,
			String unidadmedida) {
		super();
		this.medicamento = medicamento;
		this.paciente = paciente;
		this.fecha = fecha;
		this.dosis = dosis;
		this.unidadmedida = unidadmedida;
	}

	public int getIdpm() {
		return idpm;
	}

	public void setIdpm(int idpm) {
		this.idpm = idpm;
	}

	public MedicamentoVO getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(MedicamentoVO medicamento) {
		this.medicamento = medicamento;
	}

	public PacienteVO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteVO paciente) {
		this.paciente = paciente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getDosis() {
		return dosis;
	}

	public void setDosis(float dosis) {
		this.dosis = dosis;
	}

	public String getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	@Override
	public String toString() {
		return "PacienteMedicamentoVO [idpm=" + idpm + ", medicamento=" + medicamento + ", paciente=" + paciente
				+ ", fecha=" + fecha + ", dosis=" + dosis + ", unidadmedida=" + unidadmedida + "]";
	}

}
