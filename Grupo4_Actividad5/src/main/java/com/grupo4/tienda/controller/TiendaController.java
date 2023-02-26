package com.grupo4.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TiendaController {

	@GetMapping("/inicio")
	public String procInicio(){
		return "inicio";
	}
}
