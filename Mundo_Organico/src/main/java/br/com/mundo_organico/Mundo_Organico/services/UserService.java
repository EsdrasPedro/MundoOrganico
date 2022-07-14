package br.com.mundo_organico.Mundo_Organico.services;

import br.com.mundo_organico.Mundo_Organico.exception.UserInvalid;
import br.com.mundo_organico.Mundo_Organico.exception.UserNonexistentException;
import br.com.mundo_organico.Mundo_Organico.models.User;
import br.com.mundo_organico.Mundo_Organico.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // vai de 4 à 31 (o padrão do gensalt() é 10)
    private static final int complexidadeSenha = 10;

    // salvar usuário
    public User save(User user) {
        return userDAO.saveAndFlush(user);
    }

    public String criptografarPassword(User user) {
        return BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(complexidadeSenha));
    }

    // verificar o email e senha do usuário para login
    public User login(String email, String password) throws UserNonexistentException, UserInvalid {
    	
    	if(email.isBlank()) {
    		throw new UserInvalid("Insira o email.");
    	}
    	
    	if(password.isBlank()) {
    		throw new UserInvalid("Insira a senha.");
    	}

        Optional<User> user = userDAO.findByEmail(email);

        if(user.isPresent()) {
            // Se a senha estiver correta
            if (BCrypt.checkpw(password, user.get().getPassword())) {
                return user.get();
            }
            else {
                throw new UserNonexistentException("Email e/ou senha inválidos");
            }
        }
        else {
            throw new UserNonexistentException("Email e/ou senha inválidos");
        }

    }

    // pesquisar usuário por ID
    public User findById(Integer id) {
        Optional<User> obj = userDAO.findById(id);
        return obj.get();
    }
    
    // atualizar dados do usuário
    public void updateData(User user) {
        User entity = findById(user.getId());
        entity.setName(user.getName());
        entity.setCpf(user.getCpf());
        entity.setCellphone(user.getCellphone());
        userDAO.save(entity);
    }
}
