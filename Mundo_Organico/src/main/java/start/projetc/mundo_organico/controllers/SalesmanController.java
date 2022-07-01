package start.projetc.mundo_organico.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import start.projetc.mundo_organico.models.Salesman;
import start.projetc.mundo_organico.services.SalesmanService;

@RestController
@RequestMapping(value = "/vendedores")
public class SalesmanController {
	
	@Autowired
	SalesmanService salesmanService;
	
	// mostrar todos os vendedores
	@GetMapping
	public ResponseEntity<List<Salesman>> findAll() {
		List<Salesman> lista = salesmanService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	// pesquisar vendedor por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Salesman> findById(@PathVariable Long id) {
		Salesman obj = salesmanService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// criar novo vendedor
	@PostMapping
	public ResponseEntity<Salesman> create(@RequestBody Salesman salesman) {
		Salesman obj = salesmanService.createSalesman(salesman);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(salesman.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	// atualizar dados do vendedor
	@PutMapping(value = "/{id}")
	public ResponseEntity<Salesman> update(@PathVariable Long id, @RequestBody Salesman data) {
		data = salesmanService.update(id, data);
		
		return ResponseEntity.ok().body(data);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Salesman> delete(@PathVariable Long id) {
		salesmanService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}