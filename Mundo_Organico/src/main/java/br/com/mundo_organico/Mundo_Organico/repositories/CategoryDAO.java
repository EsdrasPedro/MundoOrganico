package br.com.mundo_organico.Mundo_Organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mundo_organico.Mundo_Organico.models.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
