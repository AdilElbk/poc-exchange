package ma.sopra.pocexchange.pocxchangeoffice.business;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import ma.sopra.pocexchange.pocxchangeoffice.exceptions.ExceptionErrorMessage;


@Service
public class XmlXsdSaxValidatorService {
	public boolean xmlXsdSAXValidator(String xmlPath, String xsdPath) {

		Schema schema = loadSchema(xsdPath);
		return validateXml(schema, xmlPath);

	}

	private boolean validateXml(Schema schema, String document) {

		try {
			// creating a Validator instance
			Validator validator = schema.newValidator();
			// validating the document against the schema
			SAXSource source = new SAXSource(new InputSource(new FileInputStream(document)));
			validator.setErrorHandler(new ErrorsHandlersService());
			validator.validate(source);
			ArrayList<String> errors = ((ErrorsHandlersService) validator.getErrorHandler()).getErrorList();
			if(!errors.isEmpty()) {
				throw new ExceptionErrorMessage(false,errors);
			}

		} catch (Exception e) {
			// catching all validation exceptions
			return false;
		}
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
