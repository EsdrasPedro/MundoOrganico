package br.com.mundo_organico.Mundo_Organico.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.mundo_organico.Mundo_Organico.models.Address;
import br.com.mundo_organico.Mundo_Organico.models.Ordered_Items;
import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.models.Request;
import br.com.mundo_organico.Mundo_Organico.models.User;
import br.com.mundo_organico.Mundo_Organico.repositories.OrderedItemsDAO;
import br.com.mundo_organico.Mundo_Organico.services.AddressService;
import br.com.mundo_organico.Mundo_Organico.services.ProductService;
import br.com.mundo_organico.Mundo_Organico.services.RequestService;
import br.com.mundo_organico.Mundo_Organico.services.UserService;


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
    
    @Autowired
    private UserService userService;

    @GetMapping("/produto")
    public String viewProduct(Integer id, Model model, Ordered_Items item, Integer userId) {
        Product prod = this.productService.findById(id);
        model.addAttribute("product", prod);
        model.addAttribute("item", item);
        model.addAttribute("userId", userId);

        return "request";
    }
    
    @GetMapping("/pedido")
    public String viewRequest(Integer id, Model model) {
        Request req = this.requestService.findById(id);
        List<Ordered_Items> items = requestService.listItemsByRequest(id);

        model.addAttribute("pedido", req);
        model.addAttribute("items", items);

        return "invoice";
    }

    @PostMapping("/adicionar-produto")
    public String addProduct(Product product, Ordered_Items item, Model model, Integer quant, Integer userId) {

        List<Ordered_Items> items = requestService.listItemsByUser(userId);
        Ordered_Items newItem = new Ordered_Items();

        User user = userService.findById(userId);

        Product prod = this.productService.findById(product.getId());

        item.setAmount(quant);
        item.setValue((prod.getValue()* quant));
        item.setProduct(prod);
        item.setUser(user);

        for(Ordered_Items it : items) {
            if(it.getProduct().getId().equals(prod.getId()) && it.getRequest() == null) {
                it.setAmount(item.getAmount());
                it.setValue(prod.getValue() * quant);
                orderedItemsDAO.save(it);
                return "redirect:/compra?id=" + userId;
            }
            // setando um novo item caso já tenha algum item com um pedido finalizado
            else if(it.getRequest() != null) {
                newItem.setAmount(quant);
                newItem.setValue(prod.getValue() * quant);
                newItem.setProduct(prod);
                newItem.setUser(user);

                for (Ordered_Items itemVerificar : items) {
                    if(itemVerificar.getProduct().getId().equals(prod.getId()) && itemVerificar.getRequest() == null) {
                        itemVerificar.setAmount(item.getAmount());
                        itemVerificar.setValue(prod.getValue() * quant);
                        orderedItemsDAO.save(itemVerificar);
                        return "redirect:/compra?id=" + userId;
                    }
                }

                orderedItemsDAO.save(newItem);

                return "redirect:/compra?id=" + userId;
            }
        }

        orderedItemsDAO.save(item);

        return "redirect:/compra?id=" + userId;

    }

    @PostMapping("/adicionar-endereco")
    public String addAddress(Address address, Integer userId){
        this.addressService.save(address);
        return "redirect:/compra?id=" + userId;
    }


    @GetMapping("/compra")
    public String viewShoppBag(Model model, Integer id, Ordered_Items item, Request request, Double entrega, Integer idProd, Integer userId) {

        List<Ordered_Items> backup = requestService.listItemsByUser(id);
        List<Ordered_Items> items = new ArrayList<>();

        System.out.println(items.size());

        double subTotal = 0;
        for(Ordered_Items it : backup) {
            if(it.getRequest() != null) {
                System.out.println(items.size());
            }
            else {
                items.add(it);
                subTotal += it.getValue();
            }
            
        }
        request.setSubTotal(subTotal);

        entrega = 10.0;

        request.setTotal(subTotal + entrega);

        model.addAttribute("item", item);
        model.addAttribute("request", request);
        model.addAttribute("taxa", entrega);
        model.addAttribute("idProd", idProd);
        model.addAttribute("userId", userId);
        model.addAttribute("items", items);

        return "shopping_bag";
    }
    
    @PostMapping("/criar-pedido")
    public String saveRequest(Request request) {

        List<Ordered_Items> items = requestService.listItemsByUser(request.getUser().getId());

        double total = 0;
        // indicar que os itens são do pedido que será criado e também saber o valor total desses itens
        for(Ordered_Items item : items) {

            if(item.getRequest() == null) {
                item.setRequest(request);
                total += item.getValue();
            }

        }

        // total do pedido sem a entrega
        request.setSubTotal(total);
        // total do pedido com a entrega
        request.setTotal(total + 10);

        //Data e hora do pedido
        request.setData();
        request.setHora();

        request.setStatus("CONCLUÍDO");

        requestService.save(request);
        //orderedItemsDAO.saveAll(this.items);

        return "redirect:/main-center";
    }
    
    @PostMapping("/deletar-item")
    public String deleteItem(Integer idProd, Integer userId) {

        List<Ordered_Items> items = requestService.listItemsByUser(userId);

        for(Ordered_Items it : items) {
            if(it.getProduct().getId().equals(idProd) && it.getRequest() == null) {
                orderedItemsDAO.delete(it);
                return "redirect:/compra?id=" + userId;
            }
        }

        return "redirect:/compra";
    }
    
    @PostMapping("/editar-item")
    public String updateItem(Integer idProd, Integer userId) {
        List<Ordered_Items> items = requestService.listItemsByUser(userId);

        for(Ordered_Items it : items) {
            if(it.getProduct().getId().equals(idProd) && it.getRequest() == null) {
                return "redirect:/produto?id=" + idProd;
            }
        }

        return "redirect:/produto?id=" + idProd;
    }

}
