package ma.sopra.pocexchange.pocxchangeoffice.exceptions;

import java.util.ArrayList;

import org.xml.sax.SAXParseException;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ma.sopra.pocexchange.pocxchangeoffice.entities.XmlValidationError;


public class ExceptionErrorMessage extends RuntimeException{
	private boolean isValid;
	private ArrayList<XmlValidationError> errors;
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public ArrayList<XmlValidationError> getErrors() {
		return errors;
	}
	public void setErrors(ArrayList<XmlValidationError> errors) {
		this.errors = errors;
	}
	public ExceptionErrorMessage(boolean isValid, ArrayList<XmlValidationError> errors) {
		super();
		this.isValid = isValid;
		this.errors = errors;
	}
	public ExceptionErrorMessage(String message) {
		super(message);
	}
	
	
	
		

}
