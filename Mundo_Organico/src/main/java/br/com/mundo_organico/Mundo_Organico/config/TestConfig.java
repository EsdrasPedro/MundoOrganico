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
		Product p9 = new Product(null, "Limão", "Limão muito azedo", 1.00, "Limão", c1, s1,
				"https://www.gnnews.com.br/images/noticias/3358/b981e4be7d69ebff519504f40cc8a74e.jpg");
		Product p10 = new Product(null, "Alface", "Alface do verde", 2.50, "Limão", c3, s1,
				"https://organicosinbox.com.br/wp-content/uploads/2020/11/alface-crespa-organica.jpg");
		Product p11 = new Product(null, "Alface", "Alface do verde", 2.50, "Alface", c3, s1,
				"https://organicosinbox.com.br/wp-content/uploads/2020/11/alface-crespa-organica.jpg");
		Product p12 = new Product(null, "Coentro", "Coentro verdinho", 2.50, "Coentro", c3, s1,
				"https://s2.glbimg.com/2uv6Zz8Fr8j89rvJC1mZl8wGPdo=/smart/e.glbimg.com/og/ed/f/original/2020/10/27/coriandrum-sativum-coentro-aespeciarista-.jpg");
		Product p13 = new Product(null, "Rucula", "Rucula muito boa", 2.50, "Rucula", c3, s1,
				"https://tribunadejundiai.com.br/wp-content/uploads/2022/06/Descubra-quais-sao-os-beneficios-da-rucula-para-sua-saude.jpg");
		Product p14 = new Product(null, "Rabanete", "Rabanete do bom", 2.50, "Rabanete", c2, s1,
				"https://www.solucaohidroponia.com.br/img/produtos/fotos/492_rabanete.jpg");
		Product p15 = new Product(null, "Manjericão", "Manjericão muito bom", 2.50, "Manjericão", c3, s1,
				"https://conteudo.imguol.com.br/72/2017/07/26/manjericao-getty-1501078645456_v2_450x450.jpg");
		Product p16 = new Product(null, "Menta", "Menta fresca", 2.50, "Menta", c3, s1,
				"https://www.isla.com.br/imgdata/produto/p_484.jpg");
		Product p17 = new Product(null, "Capim Santo", "Capim santo muito bom", 2.50, "Capim Santo", c3, s1,
				"https://http2.mlstatic.com/D_NQ_NP_803788-MLB41020212840_032020-W.jpg");
		Product p18 = new Product(null, "Mastruz", "Mastruz", 2.50, "Capim Santo", c3, s1,
				"https://img.irroba.com.br/fit-in/600x600/filters:fill(transparent):quality(95)/penseorg/catalog/mastruz.png");
		Product p19 = new Product(null, "Cenoura", "Cenoura bem laranja", 4.00, "Cenoura", c2, s1,
				"https://www.infoescola.com/wp-content/uploads/2010/08/cenoura_250834906.jpg");
		Product p20 = new Product(null, "Acelga", "Acelga do bom", 4.00, "Acelga", c2, s1,
				"https://www.sabornamesa.com.br/images/receitas/pins_image/r919-acelga-pin.jpg");
		Product p21 = new Product(null, "Tomate", "Tomate vermelhinho", 0.75, "Tomate", c1, s1,
				"https://cdn.wikifarmer.com/wp-content/uploads/2020/02/tomato-facts.jpg");
		Product p22 = new Product(null, "Cana", "Cana bem docinha", 3.00, "Cana", c1, s1,
				"https://brfertil.com.br/wp-content/uploads/2017/04/Depositphotos_59945891_l-2015.jpg");
		Product p23 = new Product(null, "Melancia", "Melancia bem docinha", 2.20, "Melancia", c1, s1,
				"https://hiperideal.vteximg.com.br/arquivos/ids/167698-1000-1000/51470.jpg?v=636615816266230000");
		Product p24 = new Product(null, "Beterraba", "Beterraba bom para o sangue", 2.33, "Beterraba", c2, s1,
				"https://s2.glbimg.com/HGlSDx3T6NnLymliUW0pyC2BsKQ=/620x455/e.glbimg.com/og/ed/f/original/2020/01/17/gettyimages-182175899.jpg");
		Product p25 = new Product(null, "Chuchu", "Chuchu muito bom", 1.67, "Beterraba", c2, s1,
				"https://conteudo.imguol.com.br/c/entretenimento/18/2021/09/24/chuchu-1632511726094_v2_1x1.jpg");
		Product p26 = new Product(null, "Jiló", "Jiló, sem condições de bom", 3.00, "Jiló", c2, s1,
				"https://www.receiteria.com.br/wp-content/uploads/receitas-com-jilo.jpg");
		Product p27 = new Product(null, "Jaca", "A melhor jaca dura da região", 5.15, "Jaca", c1, s1,
				"https://www.infoescola.com/wp-content/uploads/2010/04/jaca_681635947.jpg");
		Product p28 = new Product(null, "Manga Rosa", "Manga Rosa muito doce", 2.99, "Manga Rosa", c1, s1,
				"https://s2.glbimg.com/QeQ9cqGo-kE-TyD1crH7jpUiDE4=/620x455/e.glbimg.com/og/ed/f/original/2020/01/21/gettyimages-463651383.jpg");

		categoryDAO.saveAll(Arrays.asList(c1, c2, c3, c4));
		salesmanDAO.save(s1);
		productDAO.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17,
				p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28));

	}

}
