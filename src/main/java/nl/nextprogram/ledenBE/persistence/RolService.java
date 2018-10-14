package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Rol;

@Service
@Transactional
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public Rol create(Rol rol) {
		if (rol==null) {
			return null;
		}
		if (rol.getId()!=0) {
			return null;
		}
		return rolRepository.save(rol);
	}
	
	public Optional<Rol> findById(long id) {
		return rolRepository.findById(id);
	}
	
	public Iterable<Rol> findAll() {
		return rolRepository.findAll();
	}
	
	public Rol update(Rol rol) {
		if (rol==null) {
			return null;
		}
		if (rol.getId()<=0) {
			return null;
		}
		
		if (!rolRepository.findById(rol.getId()).isPresent()) {
			return null;
		};
		
		return rolRepository.save(rol);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!rolRepository.findById(id).isPresent()) {
			return false;
		};
		
		rolRepository.deleteById(id);
		return true;
	}
	
}
