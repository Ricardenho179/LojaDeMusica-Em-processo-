package br.com.loja.lojamusica.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionarios")
public class Funcionarios extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionarioid")
	private Integer id;

	@NotNull
	@NotEmpty
	@Size(max = 50, min = 4)
	private String nome;

	@NotNull
	@Column(name = "data_nasc")
	private LocalDate dataNasc;

	@SuppressWarnings("unused")
	public Funcionarios() {
		// construtor for hibernate
	}

	public Funcionarios(Integer id, String nome, LocalDate dataNasc) {
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		validarDominio();

	}

	// Construtor de teste
	public Funcionarios(String nome, LocalDate dataNasc) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		validarDominio();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionarios other = (Funcionarios) obj;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
