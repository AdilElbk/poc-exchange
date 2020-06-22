package ma.sopra.pocexchange.pocxchangeoffice.entities;

import lombok.*;
import ma.sopra.pocexchange.pocxchangeoffice.repositories.FichierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString

@Document(collection = "Fichier")
public class Fichier implements Serializable {

    @Id
    private Long idFichier;

//    @Field(value = "Description")
//    private String description;

    @Field(value ="urlFile")
    private String urlFile;

    @Field(value ="file_name")
    private String fileName ;
//
//    @Field(value = "content_type")
//    private String fileType;
    //
//    @Field(value = "date_depot")
//    private Date dateDepot;
//
//    @Field(value ="statut")
//    private String Statut;

    public Fichier(String urlFile, String fileName) {
        this.urlFile = urlFile;
        this.fileName = fileName;
//        this.fileType = fileType;


    }
}
