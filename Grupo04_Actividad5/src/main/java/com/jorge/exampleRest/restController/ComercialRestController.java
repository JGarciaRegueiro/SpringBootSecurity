package com.jorge.exampleRest.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.exampleRest.modelo.entities.Comercial;
import com.jorge.exampleRest.modelo.entities.Pedido;
import com.jorge.exampleRest.modelo.service.ComercialService;

@RestController
@RequestMapping ("/comercial")
public class ComercialRestController {
	
	@Autowired
	private ComercialService cServ;
	
	@PostMapping("/alta")
	public Comercial altaComercial (@RequestBody Comercial comercial) {
		return cServ.altaComercial(comercial);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public Boolean eliminarComercial (@PathVariable int id) {
		return cServ.eliminarComercial(id);
	}
	
	@GetMapping("/uno/{id}")
	public Comercial consultarComercial (@PathVariable int id) {
		return cServ.consultarComercial(id);
	}
	
	@GetMapping("/bycliente/{id}")
	public List<Comercial> listaComercialesPorCliente (@PathVariable int id) {
		return cServ.consultarComercialesPorCliente(id);
	}
	
	@GetMapping("/conpedidos")
	public List<Comercial> listaComercialesPorPedido() {
		return cServ.consultarComercialesConPedido();
	}
	
	@GetMapping("/pedidos/{id}")
	public List<Pedido> listaPedidosComercial (@PathVariable int id) {
		return cServ.consultarPedidosPorComercial(id);
	}

}
