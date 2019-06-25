package br.com.bemobi.desafio.desafio.repository;



import org.springframework.data.mongodb.repository.MongoRepository;


import br.com.bemobi.desafio.desafio.document.LocalizadorUniformeRecurso;

public interface LocalizadorUniformeRecursoRepository extends MongoRepository<LocalizadorUniformeRecurso, String>{
	
	
	LocalizadorUniformeRecurso findByAlias(String alias); 
	
	LocalizadorUniformeRecurso findByUrlEncurtada(String url);
	
	

}
