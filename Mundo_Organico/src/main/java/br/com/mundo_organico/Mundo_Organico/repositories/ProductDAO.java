package br.com.mundo_organico.Mundo_Organico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mundo_organico.Mundo_Organico.models.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
