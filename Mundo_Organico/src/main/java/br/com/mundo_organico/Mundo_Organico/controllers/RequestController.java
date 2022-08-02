package br.com.mundo_organico.Mundo_Organico.controllers;

import java.util.HashSet;
import java.util.Set;

import br.com.mundo_organico.Mundo_Organico.models.Address;
import br.com.mundo_organico.Mundo_Organico.services.AddressService;
import br.com.mundo_organico.Mundo_Organico.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.mundo_organico.Mundo_Organico.models.Ordered_Items;
import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.repositories.OrderedItemsDAO;
import br.com.mundo_organico.Mundo_Organico.services.ProductService;


@Controller
public class RequestController {
	
    @Autowired
    private ProductService productService;
	
	@Autowired
    private OrderedItemsDAO orderedItemsDAO;

    @Autowired
    private AddressService addressService;

    private Set<Ordered_Items> items = new HashSet<Ordered_Items>();


    @GetMapping("/produto")
    public String viewProduct(Integer id, Model model, Ordered_Items item) {
        Product prod = this.productService.findById(id);
        model.addAttribute("product", prod);
        model.addAttribute("item", item);

        return "request";
    }

    @PostMapping("/adicionar-produto")
    public String addProduct(Product product, Ordered_Items item, Model model, Integer quant) {
        Product prod = this.productService.findById(product.getId());
        item.setAmount(quant);
        item.setValue((prod.getValue()* quant));
        item.setProduct(prod);

        items.add(item);

        return "redirect:/compra";

    }

    @PostMapping("/adicionar-endereco")
    public String addAddress(Address address){
        this.addressService.save(address);
        return "redirect:/compra";
    }


    @GetMapping("/compra")
    public String viewShoppBag(Model model, Integer id, Ordered_Items item) {

        model.addAttribute("items", this.items);


        return "shopping_bag";
    }

}
