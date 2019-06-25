package br.com.bemobi.desafio.desafio.response;

public class ErrorResponse {

	public String err_code;
    public String description;
    
    
	public ErrorResponse(String err_code, String description) {
		super();
		this.err_code = err_code;
		this.description = description;
	}
    
    
}
