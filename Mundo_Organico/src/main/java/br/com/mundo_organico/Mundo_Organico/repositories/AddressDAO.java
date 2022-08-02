package br.com.mundo_organico.Mundo_Organico.repositories;

import br.com.mundo_organico.Mundo_Organico.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Integer> {


}
