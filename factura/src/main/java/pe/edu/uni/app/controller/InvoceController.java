package pe.edu.uni.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.uni.app.model.invoceModel;
import pe.edu.uni.app.service.impl.invoceServiceImpl;

@Controller
@RequestMapping("/api")
public class InvoceController {
	
	@Autowired
	private invoceServiceImpl invoceServiceImpl;

	@GetMapping("/get")
	public String listaVentas(Model model) {
		List<invoceModel> lista = invoceServiceImpl.listar();
		model.addAttribute("lista",lista);
		
		return "listar";
	}
	
	@PostMapping("/get")
	public String listaVentas(@RequestParam("numeroOtorgante") String numeroOtorgante, Model model) {
		if (numeroOtorgante.trim() =="") {
			List<invoceModel> lista = invoceServiceImpl.listar();
			model.addAttribute("lista",lista);
		}
		else {
			try {
				List<invoceModel> lista = invoceServiceImpl.listarPorID(numeroOtorgante);
				model.addAttribute("lista",lista);
			} catch (Exception e) {
				
			}
			
		}
		
		return "listar";
	}

}
