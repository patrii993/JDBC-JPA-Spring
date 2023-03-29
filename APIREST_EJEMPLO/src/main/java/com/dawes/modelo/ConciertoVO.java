package com.dawes.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="conciertos")
public class ConciertoVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idconcierto;
	private String grupo;
	private LocalDate fecha;
	private LocalTime hora;
	private float precioanticipado;
	private float preciotaquilla;
	private int plazasdisponibles;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idsala")
	private SalaVO sala;
	@Override
	public String toString() {
		return "ConciertoVO [idconcierto=" + idconcierto + ", grupo=" + grupo + ", fecha=" + fecha + ", hora=" + hora
				+ ", precioanticipado=" + precioanticipado + ", preciotaquilla=" + preciotaquilla
				+ ", plazasdisponibles=" + plazasdisponibles + ", sala=" + sala.getNombre() + "]";
	}

}


