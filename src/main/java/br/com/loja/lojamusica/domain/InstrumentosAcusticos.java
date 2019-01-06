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
@Table(name = "instrumentos_acusticos")
public class InstrumentosAcusticos extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instru_acusid")
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
	private double valor;

	@SuppressWarnings("unused")
	public InstrumentosAcusticos() {

	}

	public InstrumentosAcusticos(Integer id, String tipo, String nome, String marca, Double valor) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		validarDominio();
	}

	// Construtor de teste
	public InstrumentosAcusticos(String tipo, String nome, String marca, Double valor) {
		this.tipo = tipo;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		validarDominio();
	}

	public Integer getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public Double getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		InstrumentosAcusticos other = (InstrumentosAcusticos) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
