package ma.sopra.pocexchange.pocxchangeoffice.repositories;

import ma.sopra.pocexchange.pocxchangeoffice.entities.Fichier;

import java.util.List;
import java.util.Optional;

public abstract class FichierRepositoryImpl implements FichierRepository{
    @Override
    public <S extends Fichier> S save(S s) {
        return null;
    }

    @Override
    public Optional<Fichier> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Fichier> findAll() {
        return null;
    }
}
