package br.com.mundo_organico.Mundo_Organico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.repositories.ProductDAO;

@Service
public class ProductService {
	
    @Autowired
    private ProductDAO productDAO;

    // pesquisar e mostrar todos os produtos
    public List<Product> listProducts() {
        List<Product> lista = productDAO.findAll();
        return lista;
    }

    // pesquisar produto por ID
    public Product findById(Integer id) {
    	Optional<Product> obj = productDAO.findById(id);
    	return obj.get();
    }
}
