package start.projetc.mundo_organico.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import start.projetc.mundo_organico.models.Adress;
import start.projetc.mundo_organico.models.Category;
import start.projetc.mundo_organico.models.Order;
import start.projetc.mundo_organico.models.OrderItem;
import start.projetc.mundo_organico.models.Product;
import start.projetc.mundo_organico.models.Salesman;
import start.projetc.mundo_organico.models.Type;
import start.projetc.mundo_organico.models.User;
import start.projetc.mundo_organico.repositories.AdressRepository;
import start.projetc.mundo_organico.repositories.CategoryRepository;
import start.projetc.mundo_organico.repositories.OrderItemRepository;
import start.projetc.mundo_organico.repositories.OrderRepository;
import start.projetc.mundo_organico.repositories.ProductRepository;
import start.projetc.mundo_organico.repositories.SalesmanRepository;
import start.projetc.mundo_organico.repositories.TypeRepository;
import start.projetc.mundo_organico.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userDAO;

	@Autowired
	private AdressRepository adressDAO;

	@Autowired
	private CategoryRepository categoryDAO;

	@Autowired
	private TypeRepository typeDAO;

	@Autowired
	private SalesmanRepository salesmanDAO;

	@Autowired
	private ProductRepository productDAO;

	@Autowired
	private OrderRepository orderDAO;

	@Autowired
	private OrderItemRepository orderItemDAO;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Ygor Alves", "111.222.555.66", "(81)9xxxx-xxxx", "ygor@gmail.com", "123456789");
		User u2 = new User(null, "Maria Alves", "333.444.666.77", "(81)9xxxx-xxxx", "maria@gmail.com", "10111213");
		User u3 = new User(null, "Alan Guilherme", "444.555.777.88", "(81)9xxxx-xxxx", "alan@gmail.com", "20212223");
		User u4 = new User(null, "Felizardo da Silva", "555.666.888.99", "(81)9xxxx-xxxx", "tenfelizardo@gmail.com",
				"felizardo2024");

		Adress a1 = new Adress(null, "Rua Marechal", "49", "Próximo a praça", "não tem", u2);
		Adress a2 = new Adress(null, "Rua Morro do Pilar", "49", "Próximo a igreja", "não tem", u2);
		Adress a3 = new Adress(null, "Rua da Farmácia", "48", "Próximo a avenida", "null", u4);
		Adress a4 = new Adress(null, "Avenida Chapada do Araripe", "75", "Av. principal", "null", u1);

		Category c1 = new Category(null, "Frutas");
		Category c2 = new Category(null, "Verduras");
		Category c3 = new Category(null, "Hortaliças");
		Category c4 = new Category(null, "Temperos");

		Type t1 = new Type(null, "Maçã", c1);
		Type t2 = new Type(null, "Coloral", c4);
		Type t3 = new Type(null, "Laranja", c1);
		Type t4 = new Type(null, "Tempero", c4);
		Type t5 = new Type(null, "Limão cravo", c1);

		Salesman s1 = new Salesman(null, "Quitanda do seu Zé", "555.555.555", "contatoquitandaseuze@gmail.com",
				"1234@quitanda");

		Product p1 = new Product(null, "Laranja", "Laranja muito boa e suculenta", 1.50, s1, t3);
		Product p2 = new Product(null, "Limão", "Limão mais azedo da região", 2.0, s1, t5);

		Order o1 = new Order(null, Instant.now(), u4);
		
		OrderItem oi1 = new OrderItem(o1, p1, p1.getValue(), 2);
		OrderItem oi2 = new OrderItem(o1, p2, p2.getValue(), 4);
		
		userDAO.saveAll(Arrays.asList(u1, u2, u3, u4));
		adressDAO.saveAll(Arrays.asList(a1, a2, a3, a4));
		categoryDAO.saveAll(Arrays.asList(c1, c2, c3, c4));
		typeDAO.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		salesmanDAO.save(s1);
		productDAO.saveAll(Arrays.asList(p1, p2));
		orderDAO.save(o1);
		orderItemDAO.saveAll(Arrays.asList(oi1, oi2));
		
	}

}
