package ma.sopra.pocexchange.pocxchangeoffice.business;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;


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
//            validator.setErrorHandler(new ErrorsHandlersService());
            SAXSource source = new SAXSource(new InputSource(new FileInputStream(document)));
            validator.validate(source);
            
        } catch (Exception e) {
            // catching all validation exceptions
        	
            System.out.println();
            System.out.println(e.toString());
            
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
