package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Lid;

@Repository
public interface LidRepository extends CrudRepository<Lid, Long> {

}
