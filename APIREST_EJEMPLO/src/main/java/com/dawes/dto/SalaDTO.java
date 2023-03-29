package com.dawes.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {
	
	private String nombre;
	private String direccion;
	private int aforo;
	private List<ConciertoDTO> conciertos;

}
