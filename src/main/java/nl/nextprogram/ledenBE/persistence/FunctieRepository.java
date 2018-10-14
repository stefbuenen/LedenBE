package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Functie;

@Repository
public interface FunctieRepository extends CrudRepository<Functie, Long> {

}
