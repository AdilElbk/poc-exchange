package ma.sopra.pocexchange.pocxchangeoffice.repositories;

import ma.sopra.pocexchange.pocxchangeoffice.entities.Fichier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FichierRepository extends MongoRepository<Fichier,Long>{

}
