package ma.sopra.pocexchange.pocxchangeoffice.exceptions;

import org.springframework.http.HttpStatus;
import org.xml.sax.SAXParseException;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class ApiError {

	private HttpStatus status;
	private int row;
	private int column;
	private String message;

	ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }
	
	ApiError(HttpStatus status,SAXParseException ex,int column,int row,String message){
		this.status = status;
		this.column = ex.getColumnNumber();
		this.row = ex.getLineNumber();
		this.message = ex.getMessage();
		
	}
	public ApiError() {
		// TODO Auto-generated constructor stub
	}

	
	
}
