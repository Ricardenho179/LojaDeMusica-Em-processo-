package br.com.loja.lojamusica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="dominiozin")
public class Dominiozin extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dominioid")
	private Integer id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	
	@SuppressWarnings("unused")
	public Dominiozin() {
		// construtor for hibernate
	}
	
	public Dominiozin(String nome) {
		this.nome = nome;
		validarDominio();		
	}
	
	public Dominiozin(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
		validarDominio();		
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Dominiozin other = (Dominiozin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	

}
