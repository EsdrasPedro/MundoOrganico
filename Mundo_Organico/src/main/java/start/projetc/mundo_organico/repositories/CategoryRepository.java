package start.projetc.mundo_organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import start.projetc.mundo_organico.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
