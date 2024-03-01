package github_bethaniafreitas.Library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Reservas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;


	private String usuario;


	@JsonProperty("data_inicio")
	private String dataInicio;


	@JsonProperty("data_fim")
	private String dataFim;

	public Reservas() {

	}

	public Reservas(long id, Livro livro, String usuario, String dataInicio, String dataFim) {
		super();
		this.id = id;
		this.livro = livro;
		this.usuario = usuario;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}
