package ma.sopra.pocexchange.pocxchangeoffice.entities;

import java.util.ArrayList;

import org.xml.sax.SAXParseException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ResponseMessage {
	private String message;
	private boolean isValid;
	private ArrayList<String>errors;
	private Exception e;




	public ResponseMessage(String message, boolean isValid, Exception e) {
		super();
		this.message = message;
		this.isValid = isValid;
		this.e = e;
	}


	public ResponseMessage(String message, boolean isValid) {
		super();
		this.message = message;
		this.isValid = isValid;
	}


	public Exception getE() {
		return e;
	}


	public void setE(Exception e) {
		this.e = e;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	

}
