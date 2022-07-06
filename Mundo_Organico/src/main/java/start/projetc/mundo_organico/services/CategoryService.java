package start.projetc.mundo_organico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.projetc.mundo_organico.models.Category;
import start.projetc.mundo_organico.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryDAO;
	
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryDAO.findById(id);
		return obj.get();
	}

}
