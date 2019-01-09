package br.com.loja.lojamusica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.lojamusica.DTO.InstrumentosEletricosDTO;
import br.com.loja.lojamusica.service.InstrumentosEletricosService;

@RestController
@RequestMapping(value="lojaMusica")
public class InstrumentosEletricosController {
	
	
	private InstrumentosEletricosService instruService;
	
	@Autowired
	public InstrumentosEletricosController(InstrumentosEletricosService instruService) {
		this.instruService = instruService;
		
	}
	
	@GetMapping(value="/instrumentosEletricos")
	public ResponseEntity<List<InstrumentosEletricosDTO>> consultarIntrumentosEletricos() {
		List<InstrumentosEletricosDTO> instrumentosEletricos = instruService.findAll();
		return new ResponseEntity<List<InstrumentosEletricosDTO>> (instrumentosEletricos, HttpStatus.OK);
	}
	
	@PostMapping(value="/instrumentosEletricos")
	public ResponseEntity<?> salvarInstrumentosEletricos(@RequestBody @Valid InstrumentosEletricosDTO instruDTO) {
		instruService.salvar(instruDTO);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	@DeleteMapping(value="/instrumentosEletricos/{id}")
	public ResponseEntity<?> deletarInstrumentosEletricos(@PathVariable("id") Integer id) {
		instruService.deletar(id);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	@PutMapping(value="/instrumentosEletricos/{id}")
	public ResponseEntity<?> editarInstrumentosEletricos(@RequestBody InstrumentosEletricosDTO instruDTO){
		instruService.edit(instruDTO);
		return new ResponseEntity<> (HttpStatus.OK);
	}
}