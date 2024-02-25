package github_bethaniafreitas.Library.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String autor;

	private String titulo;

	@JsonProperty("ano_publicacao")
	private String anoPublicacao;

	@JsonIgnore
	@OneToMany(mappedBy = "livro")
	private List<Exemplar> exemplares;

	@JsonIgnore
	@OneToMany(mappedBy = "livro")
	private List<Reservas> reservas;

	private boolean ativo = true;

	public Livro() {

	}

	public Livro(long id, String autor, String titulo, String anoPublicacao, List<Exemplar> exemplares,
			List<Reservas> reservas, boolean ativo) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.exemplares = exemplares;
		this.reservas = reservas;
		this.ativo = ativo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Reservas> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}

}
