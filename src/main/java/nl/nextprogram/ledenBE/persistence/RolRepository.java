package nl.nextprogram.ledenBE.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.nextprogram.ledenBE.domain.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

}
