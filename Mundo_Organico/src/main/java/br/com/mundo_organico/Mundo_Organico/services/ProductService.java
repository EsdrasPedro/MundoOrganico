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
    
    // retornar todos os produtos que sejam da categoria fruta
    public List<Product> findByFruta() {
        List<Product> prodFrutas = productDAO.findByFruta();
        return prodFrutas;
    }

    // retornar todos os produtos que sejam da categoria verdura
    public List<Product> findByVerdura() {
        List<Product> prodVerdura = productDAO.findByVerdura();
        return prodVerdura;
    }

    public List<Product> findByHortalica() {
        List<Product> prodHortalica = productDAO.findByHortalica();
        return prodHortalica;
    }

    public List<Product> findByTempero() {
        List<Product> prodTempero = productDAO.findByTempero();
        return prodTempero;
    }
    
}
