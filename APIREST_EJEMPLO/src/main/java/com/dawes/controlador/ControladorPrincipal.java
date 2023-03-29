package com.dawes.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ConciertoVO;
import com.dawes.modelo.SalaVO;
import com.dawes.servicios.ServicioConcierto;
import com.dawes.servicios.ServicioSala;
@Controller
@RequestMapping("/")
public class ControladorPrincipal {

	@Autowired
	ServicioConcierto sc;
	@Autowired
	ServicioSala ss;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/eligesala")
	public String formularioEligeSala(Model modelo) {
		modelo.addAttribute("salas", ss.findAll());
		return "formeligesala";
	}
	@RequestMapping("/muestraconciertos")
	public String muestraconciertos(@RequestParam("idsala") int idsala, Model modelo) {
		SalaVO sala = ss.findById(idsala).get();
		modelo.addAttribute("conciertos",sc.findBySala(sala).get());
		modelo.addAttribute("sala",sala);
		return "muestraconciertos";
	}
	@RequestMapping("/formularioeligesalayfecha")
	public String formeligeSalayFecha(Model modelo) {
		modelo.addAttribute("salas",ss.findAll());
		modelo.addAttribute("conciertos",sc.findAll());
		return "formeligeSalayfecha";
	}
//	/muestraBusquedaConciertos
	@RequestMapping("/muestraBusquedaConciertos")
	public String muestraBusquedaConciertoConcreto(@RequestParam("from") LocalDate from, @RequestParam("to") LocalDate to, @RequestParam("idsala") int idsala,
			@RequestParam("grupo") String grupo, Model modelo) {
		modelo.addAttribute("conciertos",sc.findBySalaAndGrupoAndFechaBetween(ss.findById(idsala).get(), grupo, from, to).get());
		modelo.addAttribute("sala",ss.findById(idsala).get());
		return "muestraconciertos";
	}
	
	@RequestMapping("/formreserva")
	public String formularioreserva(Model modelo) {
		modelo.addAttribute("conciertos",sc.encuentraFechasLibres().get());
		return "muestrafechaslibres";
	}
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam("idconcierto") int idconcierto, Model modelo) {
		modelo.addAttribute("concierto",sc.findById(idconcierto).get());
		modelo.addAttribute("fecha",sc.findById(idconcierto).get().getFecha());
		return "modificar";
		
	}
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute ConciertoVO concierto, Model modelo) {
		
		
		SalaVO sala = concierto.getSala();
		int plazas = sala.getAforo();
		concierto.setPlazasdisponibles(plazas);
		sc.save(concierto);
		modelo.addAttribute("conciertos",sc.findBySala(sala).get());
		modelo.addAttribute("sala",sala);
		return "mostrar";
	}
	
}
