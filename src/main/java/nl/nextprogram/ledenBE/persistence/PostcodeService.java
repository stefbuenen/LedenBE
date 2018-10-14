package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Postcode;

@Service
@Transactional
public class PostcodeService {
	
	@Autowired
	private PostcodeRepository postcodeRepository;
	
	public Postcode create(Postcode postcode) {
		if (postcode==null) {
			return null;
		}
		if (postcode.getId()!=0) {
			return null;
		}
		return postcodeRepository.save(postcode);
	}
	
	public Optional<Postcode> findById(long id) {
		return postcodeRepository.findById(id);
	}
	
	public Iterable<Postcode> findAll() {
		return postcodeRepository.findAll();
	}
	
	public Postcode update(Postcode postcode) {
		if (postcode==null) {
			return null;
		}
		if (postcode.getId()<=0) {
			return null;
		}
		
		if (!postcodeRepository.findById(postcode.getId()).isPresent()) {
			return null;
		};
		
		return postcodeRepository.save(postcode);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!postcodeRepository.findById(id).isPresent()) {
			return false;
		};
		
		postcodeRepository.deleteById(id);
		return true;
	}
	
}
