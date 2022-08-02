package br.com.mundo_organico.Mundo_Organico.controllers;

import java.util.HashSet;
import java.util.Set;

import br.com.mundo_organico.Mundo_Organico.models.Address;
import br.com.mundo_organico.Mundo_Organico.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.mundo_organico.Mundo_Organico.models.Ordered_Items;
import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.models.Request;
import br.com.mundo_organico.Mundo_Organico.repositories.OrderedItemsDAO;
import br.com.mundo_organico.Mundo_Organico.services.ProductService;
import br.com.mundo_organico.Mundo_Organico.services.RequestService;


@Controller
public class RequestController {
	
    @Autowired
    private ProductService productService;
	
	@Autowired
    private OrderedItemsDAO orderedItemsDAO;

    @Autowired
    private AddressService addressService;
    
    @Autowired
    private RequestService requestService;

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
    public String viewShoppBag(Model model, Integer id, Ordered_Items item, Request request) {

        model.addAttribute("items", this.items);
        model.addAttribute("request", request);

        return "shopping_bag";
    }
    
    @PostMapping("/criar-pedido")
    public String saveRequest(Request request) {

        double total = 0;
        // indicar que os itens são do pedido que será criado e também saber o valor total desses itens
        for(Ordered_Items item : this.items) {
            item.setRequest(request);
            total += item.getValue();
        }

        request.setAmount(total);
        request.setStatus("CONCLUÍDO");

        requestService.save(request);
        orderedItemsDAO.saveAll(this.items);

        this.items = new HashSet<Ordered_Items>();

        return "redirect:/main-center";
    }

}
