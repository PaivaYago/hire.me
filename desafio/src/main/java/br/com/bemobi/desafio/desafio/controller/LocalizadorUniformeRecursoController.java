package br.com.bemobi.desafio.desafio.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bemobi.desafio.desafio.document.LocalizadorUniformeRecurso;
import br.com.bemobi.desafio.desafio.dto.LocalizadorUniformeRecursoDTO;
import br.com.bemobi.desafio.desafio.service.LocalizadorUniformeRecursoService;



@RestController
@RequestMapping(value="/")
public class LocalizadorUniformeRecursoController {

	
	@Autowired
	private LocalizadorUniformeRecursoService service; 
	 
	
	@RequestMapping(value="shorten", method = RequestMethod.GET)
	public String encurtar(@RequestParam("url") String url, @RequestParam("alias") String alias) throws JsonProcessingException {

		System.out.println(url);
		System.out.println(alias);
		
		long timeBegin = new Date().getTime();

		return service.encurtarUrl(url, alias, timeBegin);

	}
	
	
	@RequestMapping(value="{alias}", method = RequestMethod.GET)
	public ModelAndView recuperar(@PathVariable("alias") String alias){
		
		System.out.println(alias);
		
			LocalizadorUniformeRecurso url = service.acessarUrl(alias);

			return new ModelAndView("redirect:" + url.getUrlOriginal());
		
		
	}
	
	@RequestMapping(value="top10", method = RequestMethod.GET)
	public List<LocalizadorUniformeRecursoDTO> dezMais(){
			 
		return service.top10();
		
	}

	
}
