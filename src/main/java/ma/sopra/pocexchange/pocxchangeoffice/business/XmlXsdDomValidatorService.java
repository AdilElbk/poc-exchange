package ma.sopra.pocexchange.pocxchangeoffice.business;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ma.sopra.pocexchange.pocxchangeoffice.exceptions.SimpleErrorHandler;

@Service
public class XmlXsdDomValidatorService {
    public boolean xmlXsdDomValidator(String xmlPath, String xsdPath) {

        Schema schema = loadSchema(xsdPath);
        Document documentt = parseXmlDom(xmlPath);
        return validateXml(schema, documentt);

    }

    private boolean validateXml(Schema schema, Document document) {
        try {
            // creating a Validator instance
            Validator validator = schema.newValidator();

            // validating the document against the schema
            validator.validate(new DOMSource(document));

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

    private Document parseXmlDom(String name) {
        Document document = null;
        try {
            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(name));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return document;
    }
}


