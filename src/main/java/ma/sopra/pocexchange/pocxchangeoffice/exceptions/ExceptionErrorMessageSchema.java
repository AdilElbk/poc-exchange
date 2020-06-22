package ma.sopra.pocexchange.pocxchangeoffice.exceptions;

import java.util.ArrayList;

import org.xml.sax.SAXParseException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionErrorMessageSchema{

	private boolean isValid;
	private ArrayList<String> errors;
	
	
	
	public ExceptionErrorMessageSchema() {
	}


	public ExceptionErrorMessageSchema(boolean isValid, ArrayList<String> errors) {
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
