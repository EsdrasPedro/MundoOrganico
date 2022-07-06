package start.projetc.mundo_organico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import start.projetc.mundo_organico.models.Type;
import start.projetc.mundo_organico.services.TypeService;


@RestController
@RequestMapping(value = "/tipos")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	//pesquisar todos os tipos no banco de dados
	@GetMapping
	public ResponseEntity<List<Type>> findAll() {
		List<Type> lista = typeService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	//pesquisar os tipos por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Type> findById(@PathVariable Long id) {
		Type obj = typeService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

}

