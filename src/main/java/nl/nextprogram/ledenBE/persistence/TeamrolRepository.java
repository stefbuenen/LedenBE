package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Teamrol;

@Repository
public interface TeamrolRepository extends CrudRepository<Teamrol, Long> {

}
