package br.com.mundo_organico.Mundo_Organico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mundo_organico.Mundo_Organico.models.Request;


public interface RequestDAO extends JpaRepository<Request, Integer> {

	List<Request> findByUserId(Integer id);
	
}
