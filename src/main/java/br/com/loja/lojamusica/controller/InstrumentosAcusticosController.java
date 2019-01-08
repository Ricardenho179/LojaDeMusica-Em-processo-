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

import br.com.loja.lojamusica.DTO.InstrumentosAcusticosDTO;
import br.com.loja.lojamusica.service.InstrumentosAcusticosService;

@RestController
@RequestMapping(value="lojaMusica")
public class InstrumentosAcusticosController {
	
	private InstrumentosAcusticosService instruAcusService;
	
	@Autowired
	public InstrumentosAcusticosController(InstrumentosAcusticosService instruAcusService) {
		this.instruAcusService = instruAcusService;
		
	}
	
	@GetMapping(value="/instrumentosAcusticos")
	public ResponseEntity<List<InstrumentosAcusticosDTO>> listaDeInstrumentosAcusticos() {
		List<InstrumentosAcusticosDTO> instrumentosAcusticos = instruAcusService.findAll();
		//                                      Não esquecer de mostrar os caras consultados!
		//                                                              |   
		//                                                              V
		return new ResponseEntity<List<InstrumentosAcusticosDTO>> (instrumentosAcusticos, HttpStatus.OK);
	}
	
	@PostMapping(value="/instrumentosAcusticos")
	public ResponseEntity<?> salvarInstrumentosAcusticos(@RequestBody @Valid InstrumentosAcusticosDTO instruAcusDTO) {
		instruAcusService.save(instruAcusDTO);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@DeleteMapping(value="/instrumentosAcusticos/{id}")
	//Não esquecer q PathVariable Recebe parametro
	
	public ResponseEntity<?> deletarInstrumentosAcusticos(@PathVariable("id") Integer id) {
		instruAcusService.delete(id);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@PutMapping(value="/instrumentosAcusticos/{id}")
	public ResponseEntity<?> juedit(@RequestBody InstrumentosAcusticosDTO instruAcusDTO) {
		instruAcusService.edit(instruAcusDTO);
		return new ResponseEntity<> (HttpStatus.OK);
	}
}
