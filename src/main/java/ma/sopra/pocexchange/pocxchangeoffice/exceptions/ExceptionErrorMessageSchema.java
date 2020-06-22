package ma.sopra.pocexchange.pocxchangeoffice.exceptions;

import java.util.ArrayList;

import ma.sopra.pocexchange.pocxchangeoffice.entities.XmlValidationError;



public class ExceptionErrorMessageSchema{

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
	public ExceptionErrorMessageSchema(boolean isValid, ArrayList<XmlValidationError> errors) {
		super();
		this.isValid = isValid;
		this.errors = errors;
	}
	public ExceptionErrorMessageSchema() {
		super();
	}
	

	
	

}
