package ma.sopra.pocexchange.pocxchangeoffice.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ma.sopra.pocexchange.pocxchangeoffice.entities.XmlValidationError;
import ma.sopra.pocexchange.pocxchangeoffice.exceptions.ExceptionErrorMessage;


@Service
public class XmlXsdSaxValidatorService {
	public boolean xmlXsdSAXValidator(String xmlPath, String xsdPath) throws ExceptionErrorMessage, SAXException, IOException {

		Schema schema = loadSchema(xsdPath);
		return validateXml(schema, xmlPath);

	}

	private boolean validateXml(Schema schema, String document) throws ExceptionErrorMessage, SAXException, IOException{

			// creating a Validator instance
			Validator validator = schema.newValidator();
			// validating the document against the schema
			SAXSource source = new SAXSource(new InputSource(new FileInputStream(document)));
			validator.setErrorHandler(new ErrorsHandlersService());
			validator.validate(source);
			ArrayList<XmlValidationError> errors = ((ErrorsHandlersService) validator.getErrorHandler()).getErrorList();
			if(!errors.isEmpty()) 
				throw new ExceptionErrorMessage(false,errors);
			return true;

		
	}

	private Schema loadSchema(String name) {
		Schema schema = null;
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language);
			schema = factory.newSchema(new File(name));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return schema;
	}
}
