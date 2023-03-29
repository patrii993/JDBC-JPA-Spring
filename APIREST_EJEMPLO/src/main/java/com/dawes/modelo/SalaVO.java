package com.dawes.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="salas")
public class SalaVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsala;
	private String nombre;
	private String direccion;
	private int aforo;
	@OneToMany(mappedBy="sala",cascade = CascadeType.REMOVE)
	private List<ConciertoVO> conciertos;

}
