package br.com.bemobi.desafio.desafio.service;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bemobi.desafio.desafio.document.LocalizadorUniformeRecurso;
import br.com.bemobi.desafio.desafio.dto.LocalizadorUniformeRecursoDTO;
import br.com.bemobi.desafio.desafio.dto.RetornoShortenDTO;
import br.com.bemobi.desafio.desafio.repository.LocalizadorUniformeRecursoRepository;
import br.com.bemobi.desafio.desafio.response.ErrorResponse;
import br.com.bemobi.desafio.desafio.util.StatusError;


@Service
public class LocalizadorUniformeRecursoServiceImpl implements LocalizadorUniformeRecursoService{

	@Autowired
	private LocalizadorUniformeRecursoRepository urlRepository;
	
	private MongoTemplate mongoTemplate;
	
	ObjectMapper mapper;
	
	public LocalizadorUniformeRecursoServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	

	
	@Override
	public String encurtarUrl(String urlOriginal, String alias, long timeBegin) {

		try {

			ObjectMapper obj = new ObjectMapper();

			if (this.verificaAlias(alias)) {

				LocalizadorUniformeRecurso url;
				RetornoShortenDTO dto;

				url = this.create(urlOriginal, alias);

				url.setUrlEncurtada(this.encurtar(url.getId(), alias));
				
				this.update(url);

				dto = new RetornoShortenDTO(url);
				dto.setTimeTaken(timeTaken(timeBegin));

				return obj.writeValueAsString(dto);

			}

			return obj.writeValueAsString(new ErrorResponse(StatusError.ERROR_001, StatusError.ERROR_001_DESCRIPTION));

		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}
	
	
	public LocalizadorUniformeRecurso create(String urlOriginal, String alias){
		
		LocalizadorUniformeRecurso url = new LocalizadorUniformeRecurso();
		url.setAlias(alias);
		url.setQtdAcesso("1");
		url.setUrlOriginal(urlOriginal);
		
		return urlRepository.save(url);
	}
	
	public String encurtar(String id, String alias){
		
		String novaUrl;
		String apelido;
		String newHost = "localhost:8080/";
		
		if(alias != null){
			
			apelido = alias;
			
		}else {
			
			apelido = Base64.getEncoder().encodeToString(id.getBytes());
			alias = apelido;
			
		}
		
		novaUrl = newHost + apelido;
		
		return novaUrl;
		
	}
	
	public long timeTaken(long timeBegin){
		
		long timeTaken = new Date().getTime() - timeBegin;
		
		return timeTaken;
		
		
	}
	
	public LocalizadorUniformeRecurso acessarUrl(String alias){
		
		LocalizadorUniformeRecurso url = this.findByAlias(alias);
		
		int qtdAcesso = Integer.parseInt(url.getQtdAcesso());
		
		url.setQtdAcesso(String.valueOf(qtdAcesso + 1));
		
		this.update(url);
		
		return url;
		
	}
	
	public void update(LocalizadorUniformeRecurso url){
		
		 urlRepository.save(url);
		
	}

	
	public LocalizadorUniformeRecurso findByAlias(String alias){
		
		return urlRepository.findByAlias(alias);
		
	}

	public Boolean verificaAlias(String alias){
		
		LocalizadorUniformeRecurso url = this.findByAlias(alias);
		
		if(url != null){
			
			return Boolean.FALSE;
			
		}
		
		return Boolean.TRUE;
	}


	@Override
	public LocalizadorUniformeRecurso findByUrlEncurtada(String url) {
		
		return urlRepository.findByUrlEncurtada(url);
		
	}
	
	public List<LocalizadorUniformeRecursoDTO> top10(){
		
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "qtdAcesso"));
		query.limit(10);

		
		List<LocalizadorUniformeRecurso> urls = mongoTemplate.find(query, LocalizadorUniformeRecurso.class);
		
		return LocalizadorUniformeRecursoDTO.transformar(urls);
		
	}
}
