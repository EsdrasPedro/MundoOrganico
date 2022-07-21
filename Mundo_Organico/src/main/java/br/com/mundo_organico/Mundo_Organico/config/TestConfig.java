package br.com.mundo_organico.Mundo_Organico.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.mundo_organico.Mundo_Organico.models.Category;
import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.models.Salesman;
import br.com.mundo_organico.Mundo_Organico.repositories.CategoryDAO;
import br.com.mundo_organico.Mundo_Organico.repositories.ProductDAO;
import br.com.mundo_organico.Mundo_Organico.repositories.SalesmanDAO;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private SalesmanDAO salesmanDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Frutas");
		Category c2 = new Category(null, "Verduras");
		Category c3 = new Category(null, "Hortaliças");
		Category c4 = new Category(null, "Temperos");
		

		Salesman s1 = new Salesman(null, "Seu Zé", "111.222.55-61", "seuzéltda@gmail.com", "123456");

		Product p1 = new Product(null, "Maçã", "Maçã maravilhosa", 2.50, "Maçã Verde", c1, s1,
				"https://img.itdg.com.br/tdg/images/blog/uploads/2017/05/shutterstock_290834552.jpg");
		Product p2 = new Product(null, "Uva", "Uva maravilhosa", 1.50, "Uva Roxa", c1, s1,
				"https://d3ugyf2ht6aenh.cloudfront.net/stores/746/397/products/uva-brs-isis-sem-semente1-4117fb3e4898b50a5a16102264065112-1024-1024.jpg");
		Product p3 = new Product(null, "Laranja", "Laranja maravilhosa", 3.50, "Laranja cravo", c1, s1,
				"https://d3ugyf2ht6aenh.cloudfront.net/stores/746/397/products/laranja-valenciana1-d6176b7996359e3cb815221646757150-1024-1024.jpg");
		Product p4 = new Product(null, "Cebola", "Cebola muito boa faz chorar", 3.70, "Cebola roxa", c3, s1,
				"https://cdn.sistemawbuy.com.br/arquivos/559d80ebce3f8617685130317c7d7d3a/produtos/FE9CA2/cebola-roxa-organica-1810_mini.png");
		Product p5 = new Product(null, "Couve-Flor", "Couver-flor muito bom", 1.65, "Couve", c3, s1,
				"https://saude.abril.com.br/wp-content/uploads/2018/04/brocolis-couve-flor-alexsilva.jpg");
		Product p6 = new Product(null, "Cenoura", "Cenoura muito boa", 6.50, "Cenoura Orgânica", c3, s1,
				"https://galeriarural.com.br/lenildo-hortifruti/wp-content/uploads/sites/19/2020/10/Cenoura.png");
		Product p7 = new Product(null, "Beterraba", "A melhor beterraba da região", 1.00, "Beterraba", c2, s1,
				"https://d3ugyf2ht6aenh.cloudfront.net/stores/746/397/products/beterraba-440x243-995921-d72145f0ec6291e66915220416406945-1024-1024.jpg");
		Product p8 = new Product(null, "Orégano", "Orégano do bom", 4.50, "Orégano", c4, s1,
				"https://static1.conquistesuavida.com.br/articles//0/97/60/@/28168-alem-do-sabor-inconfundivel-o-oregano-t-article_block_media-2.jpg");

		categoryDAO.saveAll(Arrays.asList(c1, c2, c3, c4));
		salesmanDAO.save(s1);
		productDAO.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

	}

}
