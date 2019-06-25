package br.com.bemobi.desafio.desafio.dto;

import br.com.bemobi.desafio.desafio.document.LocalizadorUniformeRecurso;

public class RetornoShortenDTO {
	
	private String novaUrl;
	private long timeTaken;
	private String urlOriginal;

	public RetornoShortenDTO(LocalizadorUniformeRecurso url){
		
		this.novaUrl = url.getUrlEncurtada();
		this.urlOriginal = url.getUrlOriginal();
		
	}

	public RetornoShortenDTO() {
		
	}
	
	@Override
	public String toString() {
		return "[novaUrl" + ":" + novaUrl + ", timeTaken=" + timeTaken + ", urlOriginal=" + urlOriginal + "]";
	}

	public String getNovaUrl() {
		return novaUrl;
	}

	public void setNovaUrl(String novaUrl) {
		this.novaUrl = novaUrl;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}




	
	
	
	

}
