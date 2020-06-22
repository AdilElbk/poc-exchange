package ma.sopra.pocexchange.pocxchangeoffice.entities;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ResponseMessage {
	private String message;
	private boolean isValid;
	private ArrayList<String>errors;

	public ResponseMessage(String message, boolean isValid, ArrayList<String> errors) {
		super();
		this.message = message;
		this.isValid = isValid;
		this.errors = errors;
	}



	public ArrayList<String> getErrors() {
		return errors;
	}



	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}



	public ResponseMessage(String message, boolean isValid) {
		super();
		this.message = message;
		this.isValid = isValid;
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
