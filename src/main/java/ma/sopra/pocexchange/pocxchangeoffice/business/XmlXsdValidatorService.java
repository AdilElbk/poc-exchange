package ma.sopra.pocexchange.pocxchangeoffice.business;


import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ma.sopra.pocexchange.pocxchangeoffice.exceptions.SimpleErrorHandler;

@Service
public class XmlXsdValidatorService {
	public boolean validateXmlAgainstXsd(String xmlFilePath, String xsdFilePath){
		//I ADDED THIS
		SAXParserFactory saxfactory=SAXParserFactory.newInstance();
		saxfactory.setValidating(false);
		saxfactory.setNamespaceAware(true);
		try {

			SchemaFactory factory =
					SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = factory.newSchema(new File(xsdFilePath));
			Validator validator = schema.newValidator();
			 validator.validate(new StreamSource(new File(xmlFilePath)));
////			saxfactory.setSchema(schema);
//			SAXParser parser = saxfactory.newSAXParser();
//			XMLReader reader =parser.getXMLReader();
//			reader.setErrorHandler(new SimpleErrorHandler());
//			reader.parse(new InputSource(xmlFilePath));


		} catch (IOException |SAXException e) {
			System.out.println("Exception: "+e.getMessage());
			return false;
		}
		return true;
	}

}
