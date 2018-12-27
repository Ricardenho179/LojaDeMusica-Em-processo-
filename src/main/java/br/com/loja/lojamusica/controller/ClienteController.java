package br.com.loja.lojamusica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.lojamusica.DTO.ClienteDTO;
import br.com.loja.lojamusica.service.ClienteService;

@RestController
@RequestMapping(value = "lojaMusica")
public class ClienteController {

	private ClienteService cliService;

	@Autowired
	public ClienteController(ClienteService cliService) {
		this.cliService = cliService;

	}

	@GetMapping(value = "/cliente")
	public ResponseEntity<List<ClienteDTO>> obterCliente() {
		List<ClienteDTO> cliente = cliService.findAll();
		return new ResponseEntity<List<ClienteDTO>>(cliente, HttpStatus.OK);
	}
	
	@PostMapping(value="/cliente")
	public ResponseEntity<?> salvarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
		cliService.save(clienteDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
