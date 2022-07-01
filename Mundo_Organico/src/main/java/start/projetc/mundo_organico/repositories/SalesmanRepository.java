package start.projetc.mundo_organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import start.projetc.mundo_organico.models.Salesman;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {

}