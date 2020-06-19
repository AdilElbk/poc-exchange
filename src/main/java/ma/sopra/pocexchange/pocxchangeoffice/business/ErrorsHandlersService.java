package ma.sopra.pocexchange.pocxchangeoffice.business;

import javax.xml.parsers.SAXParser;

import org.springframework.stereotype.Service;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

@Service
public class ErrorsHandlersService implements ErrorHandler{
	  public void warning( SAXParseException e ) throws SAXException {
	      System.out.println(e.toString());
	    }
	
public void fatalError( SAXParseException e )
	       throws SAXException {
	      System.out.println(e.toString());
	      throw e;
	    }

public void printInfo(SAXParseException e) {
	
	System.out.println("Public ID : "+e.getPublicId());
	System.out.println("System ID: "+e.getSystemId());
	System.out.println("Line number : "+e.getLineNumber());
	System.out.println("Column number : "+e.getColumnNumber());
	System.out.println("Message : "+e.getMessage());
	
}

@Override
public void error(SAXParseException exception) throws SAXException {
	System.out.println(exception.toString());
    int errorCount=0;
	errorCount++;
	
}
}
