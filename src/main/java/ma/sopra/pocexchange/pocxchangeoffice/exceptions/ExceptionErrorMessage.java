package ma.sopra.pocexchange.pocxchangeoffice.exceptions;

import java.util.ArrayList;

import org.xml.sax.SAXParseException;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class ExceptionErrorMessage extends RuntimeException{
	private boolean isValid;
	private ArrayList<String> errors;
	
	
	
	public ExceptionErrorMessage() {
	}
	public ExceptionErrorMessage(boolean isValid, ArrayList<String> errors) {
		this.isValid = isValid;
		this.errors = errors;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public ArrayList<String> getErrors() {
		return errors;
	}
	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}

	
	

}
