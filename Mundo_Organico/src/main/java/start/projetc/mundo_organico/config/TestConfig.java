package start.projetc.mundo_organico.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import start.projetc.mundo_organico.models.Adress;
import start.projetc.mundo_organico.models.User;
import start.projetc.mundo_organico.repositories.AdressRepository;
import start.projetc.mundo_organico.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userDAO;
	
	@Autowired
	private AdressRepository adressDAO;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Ygor Alves", "111.222.555.66", "(81)9xxxx-xxxx", "ygor@gmail.com", "123456789");
		User u2 = new User(null, "Maria Alves", "333.444.666.77", "(81)9xxxx-xxxx", "maria@gmail.com", "10111213");
		User u3 = new User(null, "Alan Guilherme", "444.555.777.88", "(81)9xxxx-xxxx", "alan@gmail.com", "20212223");
		User u4 = new User(null, "Felizardo da Silva", "555.666.888.99", "(81)9xxxx-xxxx", "tenfelizardo@gmail.com", "felizardo2024");
		
		Adress a1 = new Adress(null, "Rua Marechal", "49", "Próximo a praça", "não tem", u2);
		Adress a2 = new Adress(null, "Rua Morro do Pilar", "49", "Próximo a igreja", "não tem", u2);
		Adress a3 = new Adress(null, "Rua da Farmácia", "48", "Próximo a avenida", "null", u4);
		Adress a4 = new Adress(null, "Avenida Chapada do Araripe", "75", "Av. principal", "null", u1);
		
		userDAO.saveAll(Arrays.asList(u1, u2, u3, u4));
		adressDAO.saveAll(Arrays.asList(a1, a2, a3, a4));
		
	}
	
}
