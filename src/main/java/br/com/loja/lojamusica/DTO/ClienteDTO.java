package br.com.loja.lojamusica.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteDTO {
	
	private Integer id;
	
	@NotEmpty
	@NotNull
	private String nome;
	
	@NotEmpty
	@NotNull
	private String email;
	
	@NotEmpty
	@NotNull
	private String cpf;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
