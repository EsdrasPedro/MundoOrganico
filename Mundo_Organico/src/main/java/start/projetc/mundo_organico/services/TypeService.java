package start.projetc.mundo_organico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.projetc.mundo_organico.models.Type;
import start.projetc.mundo_organico.repositories.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository typeDAO;
	
	public List<Type> findAll() {
		return typeDAO.findAll();
	}
	
	public Type findById(Long id) {
		Optional<Type> obj = typeDAO.findById(id);
		
		return obj.get();
	}
	
}

