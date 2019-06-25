package br.com.bemobi.desafio.desafio.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bemobi.desafio.desafio.document.LocalizadorUniformeRecurso;
import br.com.bemobi.desafio.desafio.dto.LocalizadorUniformeRecursoDTO;

public interface LocalizadorUniformeRecursoService {
	
	
	public String encurtarUrl(String url, String alias, long timeBegin) throws JsonProcessingException;
	
	public LocalizadorUniformeRecurso findByUrlEncurtada(String url);
	
	public LocalizadorUniformeRecurso acessarUrl(String alias);
	
	public LocalizadorUniformeRecurso findByAlias(String alias);
	
	public List<LocalizadorUniformeRecursoDTO> top10();
	

}
