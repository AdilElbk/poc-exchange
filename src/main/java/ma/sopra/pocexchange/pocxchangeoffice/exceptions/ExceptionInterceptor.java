package ma.sopra.pocexchange.pocxchangeoffice.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.xml.sax.SAXParseException;


@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ExceptionErrorMessage.class)
	public ResponseEntity<Object> handleParsingExceptions(ExceptionErrorMessage parsingException){

		ExceptionErrorMessageSchema exceptionSchema = new ExceptionErrorMessageSchema(parsingException.isValid(),parsingException.getErrors());

		return new ResponseEntity<Object>(exceptionSchema,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
