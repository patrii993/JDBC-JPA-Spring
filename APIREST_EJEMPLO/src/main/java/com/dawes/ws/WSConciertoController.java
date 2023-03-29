package com.dawes.ws;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.dto.ConciertoDTO;
import com.dawes.dto.SalaDTO;
import com.dawes.modelo.ConciertoVO;
import com.dawes.modelo.SalaVO;
import com.dawes.servicios.ServicioConcierto;
import com.dawes.servicios.ServicioSala;

@RestController
public class WSConciertoController {
	@Autowired
	ServicioConcierto sc;
	@Autowired
	ServicioSala ss;

	@GetMapping("/conciertos")
	public ResponseEntity<?> consultaConciertos() {
		List<ConciertoDTO> conciertoDTO = new ArrayList<>();
		try {
			Iterable<ConciertoVO> conciertos = sc.findAll();

			for (ConciertoVO c : conciertos) {
				conciertoDTO.add(new ConciertoDTO(c.getGrupo(), c.getFecha(), c.getHora(), c.getPreciotaquilla(),
						c.getSala().getNombre()));
			}

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(conciertoDTO, HttpStatus.OK);
	}

//buscar por id
	@GetMapping("/conciertos/{idconcierto}")
	public ResponseEntity<?> consultaId(@PathVariable Integer idconcierto) {
		ConciertoDTO c = new ConciertoDTO();
		try {
			ConciertoVO concierto = sc.findById(idconcierto).get();
			c.setGrupo(concierto.getGrupo());
			c.setFecha(concierto.getFecha());
			c.setHora(concierto.getHora());
			c.setPreciotaquilla(concierto.getPreciotaquilla());
			c.setSala(concierto.getSala().getNombre());

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	// buscar por fecha y grupo
	@GetMapping("/conciertos/{grupo}/{fecha}")
	public ResponseEntity<?> consultaFechaGrupo(@PathVariable String grupo, @PathVariable LocalDate fecha) {
		List<ConciertoDTO> conciertoDTO = new ArrayList<>();
		try {
			List<ConciertoVO> conciertos = sc.findByGrupoAndFecha(grupo, fecha).get();
			for (ConciertoVO c : conciertos) {
				conciertoDTO.add(new ConciertoDTO(c.getGrupo(), c.getFecha(), c.getHora(), c.getPreciotaquilla(),
						c.getSala().getNombre()));
			}
			return new ResponseEntity<>(conciertoDTO, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	// Inserta un concierto
	/*
	 * { "grupo":"Malumo", "fecha":"2023-05-05", "hora":"12:35:00",
	 * "plazasdisponibles":12, "preciotaquilla": 21, "sala":{ "idsala":2,
	 * "nombre":"Tiffanys" }
	 * 
	 * }
	 */
	// Persiste un concierto
	@PostMapping("/concierto")
	public ResponseEntity<?> creaConcierto(@RequestBody ConciertoVO concierto) {
		ConciertoVO c;
		try {
			c = sc.save(concierto);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Modifica el concierto buscado en el fecha y grupo.
	@PutMapping("/concierto/{grupo}/{fecha}")
	public ResponseEntity<?> modificaConciertoFechaGrupo(@RequestBody ConciertoVO concierto, @PathVariable String grupo,
			@PathVariable LocalDate fecha) {
		ConciertoVO modificado = null;
		try {
			List<ConciertoVO> conciertos = sc.findByGrupoAndFecha(grupo, fecha).get();

			for (ConciertoVO modificar : conciertos) {
				modificar.setGrupo(concierto.getGrupo());
				modificar.setFecha(concierto.getFecha());
				modificar.setPreciotaquilla(concierto.getPreciotaquilla());
				modificar.setHora(concierto.getHora());
				modificar.setPrecioanticipado(concierto.getPrecioanticipado());
				modificar.setSala(concierto.getSala());
				modificado = sc.save(modificar);
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(modificado, HttpStatus.OK);
	}

	// Eliminar los conciertos por id
	@DeleteMapping("/concierto/{idconcierto}")
	public ResponseEntity<?> eliminaConciertoId(@PathVariable Integer idconcierto) {
		try {
			sc.deleteById(idconcierto);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(idconcierto, HttpStatus.OK);
	}

	// buscar una sala

	@GetMapping("/salas")
	public ResponseEntity<?> consultaSalas() {
		List<SalaDTO> salaDTO = new ArrayList<>();
		try {
			Iterable<SalaVO> salas = ss.findAll();
			for (SalaVO s : salas) {
				List<ConciertoDTO> conciertoDTO = new ArrayList<>();
				Iterable<ConciertoVO> conciertos = sc.findBySala(s).get();
				for (ConciertoVO c : conciertos) {
					conciertoDTO.add(new ConciertoDTO(c.getGrupo(), c.getFecha(), c.getHora(), c.getPreciotaquilla(),
							s.getNombre()));
				}
				salaDTO.add(new SalaDTO(s.getNombre(), s.getDireccion(), s.getAforo(), conciertoDTO));
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(salaDTO, HttpStatus.OK);
	}

	// buscar una sala por nombre
	@GetMapping("/salas/{nombre}")
	public ResponseEntity<?> consultaConciertosSala(@PathVariable String nombre) {
		List<SalaDTO> salaDTO = new ArrayList<>();
		try {
			Iterable<SalaVO> salas = ss.findAll();
			for (SalaVO s : salas) {
				if (s.getNombre().equals(nombre)) {
					List<ConciertoDTO> conciertoDTO = new ArrayList<>();
					Iterable<ConciertoVO> conciertos = sc.findBySala(s).get();
					for (ConciertoVO c : conciertos) {
						conciertoDTO.add(new ConciertoDTO(c.getGrupo(), c.getFecha(), c.getHora(),
								c.getPreciotaquilla(), s.getNombre()));
					}
					salaDTO.add(new SalaDTO(s.getNombre(), s.getDireccion(), s.getAforo(), conciertoDTO));
				}
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(salaDTO, HttpStatus.OK);
	}

	// modidifica un concierto

	@PutMapping("/sala/{nombre}/{grupo}")
	public ResponseEntity<?> modificaSalaConcierto(@RequestBody ConciertoVO concierto, @PathVariable String nombre,
			@PathVariable String grupo) {
		ConciertoVO modificar = null;
		try {
			SalaVO sala = ss.findByNombre(nombre).get();
			List<ConciertoVO> c = sc.findBySalaAndGrupo(sala, grupo).get();
			for (ConciertoVO con : c) {
				con.setGrupo(concierto.getGrupo());
				con.setFecha(concierto.getFecha());
				con.setHora(concierto.getHora());
				con.setPrecioanticipado(concierto.getPrecioanticipado());
				con.setPreciotaquilla(concierto.getPreciotaquilla());
				con.setPlazasdisponibles(concierto.getPlazasdisponibles());
				con.setSala(concierto.getSala());
				modificar = sc.save(con);
			}
			return new ResponseEntity<>(modificar, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//Inserta sala
	// Persiste un concierto
	@PostMapping("/sala")
	public ResponseEntity<?> creaSala(@RequestBody SalaVO sala) {
		SalaVO s;
		try {
			s = ss.save(sala);
			return new ResponseEntity<>(s, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
