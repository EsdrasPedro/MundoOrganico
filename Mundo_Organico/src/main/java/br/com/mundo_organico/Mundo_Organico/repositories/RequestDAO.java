package br.com.mundo_organico.Mundo_Organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mundo_organico.Mundo_Organico.models.Request;

@Repository
public interface RequestDAO extends JpaRepository<Request, Integer> {

}
