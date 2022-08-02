package br.com.mundo_organico.Mundo_Organico.services;

import br.com.mundo_organico.Mundo_Organico.models.Address;

import br.com.mundo_organico.Mundo_Organico.repositories.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public Address save(Address address ) {
        return addressDAO.save(address);
    }
}
