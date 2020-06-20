package ma.sopra.pocexchange.pocxchangeoffice.business;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;

import org.springframework.stereotype.Service;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

@Service
public class ErrorsHandlersService implements ErrorHandler{
	
	private ArrayList<String> errorList = new ArrayList<String>();
	
	
	  public ArrayList<String> getErrorList() {
		return errorList;
	}

	public void warning( SAXParseException e ) throws SAXException {
	      System.out.println(e.toString());
	    }
	
public void fatalError( SAXParseException e )
	       throws SAXException {
//	      System.out.println(e.toString());
	      throw e;
	    }

public void printInfo(SAXParseException e) {
	
	System.out.println("Column number : "+e.getColumnNumber());
	System.out.println("Message : "+e.getMessage());
	System.out.println("Element : "+e.getLocalizedMessage());
}

@Override
public void error(SAXParseException exception) throws SAXException {
    errorList.add(exception.toString());
	printInfo(exception);
	
}
}
