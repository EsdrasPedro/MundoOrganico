package br.com.mundo_organico.Mundo_Organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mundo_organico.Mundo_Organico.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

	public User findByEmailAndPassword(String email, String password);

}
