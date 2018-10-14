package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Teamdeelname;

@Repository
public interface TeamdeelnameRepository extends CrudRepository<Teamdeelname, Long> {

}
