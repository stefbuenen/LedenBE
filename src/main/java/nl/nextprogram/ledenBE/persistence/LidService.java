package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Lid;

@Service
@Transactional
public class LidService {
	
	@Autowired
	private LidRepository lidRepository;
	
	public Lid create(Lid Lid) {
		if (Lid==null) {
			return null;
		}
		if (Lid.getId()!=0) {
			return null;
		}
		return lidRepository.save(Lid);
	}
	
	public Optional<Lid> findById(long id) {
		return lidRepository.findById(id);
	}
	
	public Iterable<Lid> findAll() {
		return lidRepository.findAll();
	}
	
	public Lid update(Lid Lid) {
		if (Lid==null) {
			return null;
		}
		if (Lid.getId()<=0) {
			return null;
		}
		
		if (!lidRepository.findById(Lid.getId()).isPresent()) {
			return null;
		};
		
		return lidRepository.save(Lid);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!lidRepository.findById(id).isPresent()) {
			return false;
		};
		
		lidRepository.deleteById(id);
		return true;
	}
	
}
