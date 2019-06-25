package br.com.bemobi.desafio.desafio.dto;


import java.util.List;
import java.util.stream.Collectors;

import br.com.bemobi.desafio.desafio.document.LocalizadorUniformeRecurso;

public class LocalizadorUniformeRecursoDTO {


	private String urlOriginal;
	private String urlEncurtada;
	private String qtdAcesso;
	private String alias;
	
	
	public LocalizadorUniformeRecursoDTO(LocalizadorUniformeRecurso url){
		
		this.urlOriginal = url.getUrlOriginal();
		this.urlEncurtada = url.getUrlEncurtada();
		this.qtdAcesso = url.getQtdAcesso();
		this.alias = url.getAlias();
		
	}


	public LocalizadorUniformeRecursoDTO() {
		super();
	}


	public String getUrlOriginal() {
		return urlOriginal;
	}
	
	
	
	public String getUrlEncurtada() {
		return urlEncurtada;
	}


	public String getQtdAcesso() {
		return qtdAcesso;
	}

	
	public String getAlias() {
		return alias;
	}

	
	
	public static List<LocalizadorUniformeRecursoDTO> transformar(List<LocalizadorUniformeRecurso> urls){
		
		return urls.stream().map(LocalizadorUniformeRecursoDTO::new).collect(Collectors.toList());
		
	}
	
}
