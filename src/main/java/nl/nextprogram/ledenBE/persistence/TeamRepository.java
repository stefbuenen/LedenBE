package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

}
