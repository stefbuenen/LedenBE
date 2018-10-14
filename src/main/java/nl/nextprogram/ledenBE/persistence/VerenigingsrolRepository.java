package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Verenigingsrol;

@Repository
public interface VerenigingsrolRepository extends CrudRepository<Verenigingsrol, Long> {

}
