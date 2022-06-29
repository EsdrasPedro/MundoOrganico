package start.projetc.mundo_organico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import start.projetc.mundo_organico.models.User;
import start.projetc.mundo_organico.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userDAO;

	public List<User> findAll() {
		return userDAO.findAll();	
	}
	
	public User findById(Long id) {
		Optional<User> obj = userDAO.findById(id);
		return obj.get();
	}
	
	//Encriptografar uma senha
			@Bean
			public PasswordEncoder getPasswordEncoder() {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				return encoder;
			}
		
		//Salvar um novo usuário
		public User createUser(User obj) {
			
			//Encriptografando a senha que o usuário digita
			obj.setPassword(getPasswordEncoder().encode(obj.getPassword()));

			return userDAO.save(obj);
		}
		
		//Atualizar dados do usuário
		public User update(Long id, User data) {
			User entity = userDAO.getOne(id);
			updateData(entity, data);
			return userDAO.save(entity);
		}
		
		//Função para atualizar os dados do usuário
		private void updateData(User entity, User data) {
			entity.setName(data.getName());
			entity.setTelefone(data.getTelefone());
		}

		public void delete(Long id) {
			userDAO.deleteById(id);
		}
}
