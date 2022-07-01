package start.projetc.mundo_organico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import start.projetc.mundo_organico.models.Salesman;
import start.projetc.mundo_organico.repositories.SalesmanRepository;

@Service
public class SalesmanService {

	@Autowired
	SalesmanRepository salesmanDAO;

	public List<Salesman> findAll() {
		List<Salesman> lista = salesmanDAO.findAll();
		return lista;
	}

	public Salesman findById(Long id) {
		Optional<Salesman> obj = salesmanDAO.findById(id);
		return obj.get();
	}

	// Método para encriptografar a senha do vendedor
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	// salvar vendedor
	public Salesman createSalesman(Salesman salesman) {

		salesman.setPassword(getPasswordEncoder().encode(salesman.getPassword()));

		return salesmanDAO.save(salesman);
	}

	// atualizar dados do vendedor
	public Salesman update(Long id, Salesman data) {
		Salesman entity = salesmanDAO.getOne(id);
		updateData(entity, data);
		
		return salesmanDAO.save(entity);
	}

	// método para atualizar os dados do vendedor
	public void updateData(Salesman entity, Salesman data) {
		
		entity.setFantasy_name(data.getFantasy_name());
	}
	
	// método para deletar um vendedor por id
	public void delete(Long id) {
		salesmanDAO.deleteById(id);
	}

}
