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

import br.com.loja.lojamusica.DTO.FuncionariosDTO;
import br.com.loja.lojamusica.domain.Funcionarios;
import br.com.loja.lojamusica.service.FuncionariosService;

@RestController
@RequestMapping(value="lojaMusica")
public class FuncionariosController {
	
	private FuncionariosService funService;
	
	@Autowired
	public FuncionariosController(FuncionariosService funService) {
		this.funService = funService;
		
	}
	
	@GetMapping(value="/funcionarios")
	public ResponseEntity<List <FuncionariosDTO>> obterFuncionarios() {
		List<FuncionariosDTO> funcionarios = funService.findAll();
		return new ResponseEntity<List<FuncionariosDTO>> (funcionarios, HttpStatus.OK); 
	}
	
	@PostMapping(value="/funcionrios")
	public ResponseEntity<?> salvar(@RequestBody @Valid FuncionariosDTO funDTO) {
		funService.save(funDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
