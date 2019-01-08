package br.com.loja.lojamusica.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class InstrumentosEletricosDTO {
	
	private Integer id;
	
	@NotNull
	@NotEmpty
	private String tipo;
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String marca;
	@NotNull
	@NotEmpty
	private String amplificador;
	@NotNull
	@NotEmpty
	private String caixaSom;
	
	@NotNull
	private double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAmplificador() {
		return amplificador;
	}

	public void setAmplificador(String amplificador) {
		this.amplificador = amplificador;
	}

	public String getCaixaSom() {
		return caixaSom;
	}

	public void setCaixaSom(String caixaSom) {
		this.caixaSom = caixaSom;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
