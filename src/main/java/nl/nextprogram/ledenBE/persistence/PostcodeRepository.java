package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Postcode;

@Repository
public interface PostcodeRepository extends CrudRepository<Postcode, Long> {

}
