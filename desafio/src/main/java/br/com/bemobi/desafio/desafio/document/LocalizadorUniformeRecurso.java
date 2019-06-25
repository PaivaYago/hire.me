package br.com.bemobi.desafio.desafio.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url")
public class LocalizadorUniformeRecurso {

	@Id
	private String id;
	
	private String urlOriginal;
	
	private String alias;
	
	private String urlEncurtada;
	
	private String qtdAcesso;
	
	
	public LocalizadorUniformeRecurso() {
	
	}


	public LocalizadorUniformeRecurso(String urlOriginal, String alias, String urlEncurtada, String qtdAcesso) {
		super();
		this.urlOriginal = urlOriginal;
		this.alias = alias;
		this.urlEncurtada = urlEncurtada;
		this.qtdAcesso = qtdAcesso;
	}


	@Override
	public String toString() {
		return "LocalizadorUniformeRecurso [id=" + id + ", urlOriginal=" + urlOriginal + ", alias=" + alias
				+ ", urlEncurtada=" + urlEncurtada + ", qtdAcesso=" + qtdAcesso + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUrlOriginal() {
		return urlOriginal;
	}


	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getUrlEncurtada() {
		return urlEncurtada;
	}


	public void setUrlEncurtada(String urlEncurtada) {
		this.urlEncurtada = urlEncurtada;
	}


	public String getQtdAcesso() {
		return qtdAcesso;
	}


	public void setQtdAcesso(String qtdAcesso) {
		this.qtdAcesso = qtdAcesso;
	}


	
	
	
}
