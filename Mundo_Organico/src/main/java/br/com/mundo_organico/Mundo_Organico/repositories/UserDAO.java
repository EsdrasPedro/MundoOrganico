package br.com.mundo_organico.Mundo_Organico.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mundo_organico.Mundo_Organico.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

	public User findByEmailAndPassword(String email, String password);
	
	Optional<User> findByEmail(String email);
	
	@Query("SELECT u From User u WHERE u.email LIKE :email")
	User findByEmail1(@Param("email") String email);

	@Query("SELECT u From User u WHERE u.codVerificar LIKE :cod")
	User findByCod(@Param("cod") String cod);

}
