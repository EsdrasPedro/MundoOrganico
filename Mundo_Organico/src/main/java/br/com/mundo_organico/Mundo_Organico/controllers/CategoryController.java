package br.com.mundo_organico.Mundo_Organico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.services.ProductService;

@Controller
public class CategoryController {
    
	
	@Autowired
    private ProductService productService;

    @GetMapping("/frutas")
    public String viewCatFrut(Model model) {

        List<Product> products = productService.findByFruta();
        model.addAttribute("products", products);

        return "main-fruit";
    }

    @GetMapping("/verduras")
    public String viewCatVeget(Model model) {

        List<Product> products = productService.findByVerdura();
        model.addAttribute("products", products);

        return "main-vegetable";
    }

    @GetMapping("/hortalicas")
    public String viewCatHort(Model model) {

        List<Product> products = productService.findByHortalica();
        model.addAttribute("products", products);

        return "main-vegetable-Hort";
    }

    @GetMapping("/temperos")
    public String viewCatSeas(Model model) {

        List<Product> products = productService.findByTempero();
        model.addAttribute("products", products);

        return "main-seasonings";
    }
}
