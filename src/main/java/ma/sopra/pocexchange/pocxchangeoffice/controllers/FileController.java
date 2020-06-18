package ma.sopra.pocexchange.pocxchangeoffice.controllers;
import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;

import java.util.List;
import java.util.stream.Collectors;

import ma.sopra.pocexchange.pocxchangeoffice.business.FileStorageService;
import ma.sopra.pocexchange.pocxchangeoffice.business.XmlXsdDomValidatorService;
import ma.sopra.pocexchange.pocxchangeoffice.business.XmlXsdValidatorService;
import ma.sopra.pocexchange.pocxchangeoffice.entities.Fichier;
import ma.sopra.pocexchange.pocxchangeoffice.entities.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;



import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("{*}")
public class FileController{
    Fichier xmlfichier;
    Fichier xsdFichier;
    @Autowired
    FileStorageService storageService;
  
    
    @Autowired
    XmlXsdDomValidatorService xmlXsdDOMValidatorService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("xmlfile") MultipartFile xmlfile,@RequestParam("xsdfile")MultipartFile xsdFile) {
        String message = "", xmlFilePath, xsdFilePath;
        try {

            xmlFilePath = storageService.save(xsdFile);
            xsdFilePath = storageService.save(xmlfile);
            message = "Uploaded the files successfully: " + xmlfile.getOriginalFilename()+" & "+xsdFile.getOriginalFilename();
          System.out.println(xmlXsdDOMValidatorService.xmlXsdDomValidator(xsdFilePath,xmlFilePath));
          return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
          message = "Could not upload the file: " + xmlfile.getOriginalFilename() + " & " +xsdFile.getOriginalFilename()+ "!";
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }

    }

    @GetMapping("/listfiles")
    public ResponseEntity<List<Fichier>> getListFiles() {
        List<Fichier> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new Fichier(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


}