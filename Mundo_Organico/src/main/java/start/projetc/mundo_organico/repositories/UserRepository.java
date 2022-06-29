package start.projetc.mundo_organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import start.projetc.mundo_organico.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
