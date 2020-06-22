package ma.sopra.pocexchange.pocxchangeoffice.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ma.sopra.pocexchange.pocxchangeoffice.business.FileStorageService;
import ma.sopra.pocexchange.pocxchangeoffice.business.XmlXsdSaxValidatorService;
import ma.sopra.pocexchange.pocxchangeoffice.entities.Fichier;
import ma.sopra.pocexchange.pocxchangeoffice.entities.ResponseMessage;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("{*}")
public class FileController{
	
	Fichier xmlfichier;
	Fichier xsdFichier;
	@Autowired
	FileStorageService storageService;


	//    @Autowired
	//    XmlXsdDomValidatorService xmlXsdDOMValidatorService;

	@Autowired
	XmlXsdSaxValidatorService xmlXsdSaxValidatorService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("xmlfile") MultipartFile xmlfile,@RequestParam("xsdfile")MultipartFile xsdFile) {
		String message = "", xmlFilePath, xsdFilePath;
		boolean isValid=false;
		ArrayList<String> errors;
		try {

			xmlFilePath = storageService.save(xsdFile);
			xsdFilePath = storageService.save(xmlfile);
			message = "Uploaded the files successfully: " + xmlfile.getOriginalFilename()+" & "+xsdFile.getOriginalFilename();
			
			//isValid
			isValid = xmlXsdSaxValidatorService.xmlXsdSAXValidator(xsdFilePath,xmlFilePath);
			
			System.out.println();
			
			return new ResponseEntity<ResponseMessage>(new ResponseMessage(message,isValid), HttpStatus.OK);
			
		} catch (Exception e) {
			message = "Could not upload the file: " + xmlfile.getOriginalFilename() + " & " +xsdFile.getOriginalFilename()+ "!";
			return new ResponseEntity<ResponseMessage>(new ResponseMessage(message,isValid),HttpStatus.OK);
		}

	}

//	@GetMapping("/listfiles")
//	public ResponseEntity<List<Fichier>> getListFiles() {
//		List<Fichier> fileInfos = storageService.loadAll().map(path -> {
//			String filename = path.getFileName().toString();
//			String url = MvcUriComponentsBuilder
//					.fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
//
//			return new Fichier(filename, url);
//		}).collect(Collectors.toList());
//		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
//	}


}