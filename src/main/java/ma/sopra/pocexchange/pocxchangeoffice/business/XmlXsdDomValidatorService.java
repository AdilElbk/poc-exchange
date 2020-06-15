package ma.sopra.pocexchange.pocxchangeoffice.business;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ma.sopra.pocexchange.pocxchangeoffice.exceptions.SimpleErrorHandler;

@Service
public class XmlXsdDomValidatorService {
public boolean xmlXsdDomValidator(String xmlPath,String xsdPath) {
		String xml = new File(xmlPath).getPath();

	
	try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		factory.setSchema(schemaFactory.newSchema(new Source[] {new StreamSource(new File(xsdPath))}));
		DocumentBuilder builder= factory.newDocumentBuilder();
		builder.setErrorHandler(new SimpleErrorHandler());
		Document document = builder.parse(new InputSource(xml));


	} catch (SAXException |ParserConfigurationException | IOException e) {
        System.out.println("Exception: "+e.getMessage());
		return false;
	}
	return true;
}


}
