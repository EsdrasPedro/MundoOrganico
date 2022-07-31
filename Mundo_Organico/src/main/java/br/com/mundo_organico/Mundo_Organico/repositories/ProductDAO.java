package br.com.mundo_organico.Mundo_Organico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.mundo_organico.Mundo_Organico.models.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	
    @Query(value = "SELECT * FROM Product u WHERE u.category_id = 1", nativeQuery = true)
    List<Product> findByFruta();

    @Query(value = "SELECT * FROM Product u WHERE u.category_id = 2", nativeQuery = true)
    List<Product> findByVerdura();

    @Query(value = "SELECT * FROM Product u WHERE u.category_id = 3", nativeQuery = true)
    List<Product> findByHortalica();

    @Query(value = "SELECT * FROM Product u WHERE u.category_id = 4", nativeQuery = true)
    List<Product> findByTempero();

	
}
