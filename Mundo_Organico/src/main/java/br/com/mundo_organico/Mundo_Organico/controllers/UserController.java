package br.com.mundo_organico.Mundo_Organico.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mundo_organico.Mundo_Organico.exception.UserInvalid;
import br.com.mundo_organico.Mundo_Organico.exception.UserNonexistentException;
import br.com.mundo_organico.Mundo_Organico.models.Product;
import br.com.mundo_organico.Mundo_Organico.models.Request;
import br.com.mundo_organico.Mundo_Organico.models.User;
import br.com.mundo_organico.Mundo_Organico.repositories.UserDAO;
import br.com.mundo_organico.Mundo_Organico.services.ProductService;
import br.com.mundo_organico.Mundo_Organico.services.RequestService;
import br.com.mundo_organico.Mundo_Organico.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private RequestService requestService;

	@GetMapping("/")
	public String viewIndex(Model model) {

		List<Product> list = productService.listProducts();
		for (Product p : list) {
			if (p.getId().equals(2)) {
				break;
			}
			model.addAttribute("products", p);
		}
		for (Product p : list) {
			if (p.getId().equals(9)) {
				break;
			}
			model.addAttribute("products2", p);
		}
		for (Product p : list) {
			if (p.getId().equals(6)) {
				break;
			}
			model.addAttribute("products3", p);
		}

		return "index";
	}

	@GetMapping("/cadastro")
	public String viewUsuario() {
		return "register";
	}

	@GetMapping("/esqueceu-senha")
	public String viewPassword() {
		return "password1";
	}

	@PostMapping("/redefinir-senha")
	public String viewPassword1(RedirectAttributes ra, String email) {

		try {
			userService.requestAlterPassword(email);
			return "redirect:/alterar-senha";
		} catch (UserNonexistentException ue) {
			ra.addFlashAttribute("msgErroAdd", ue.getMessage());
		}

		return "redirect:/esqueceu-senha";

	}

	@GetMapping("/alterar-senha")
	public String viewAlterPassword() {
		return "password2";
	}

	@PostMapping("/nova-senha")
	public String viewAlterPassword(User user, String passwordValid, Model model, RedirectAttributes ra) {

		try {

			// verificar se a senha digitada é igual a senha de confirmação
			userService.validPassword(user, passwordValid);

			User u = userService.searchByCod(user.getCodVerificar());

			// comparar se o código digitado pelo usuário é igual ao que estar no banco de
			// dados
			userService.validCod(u, user);

			// user.setCodVerificar(null);
			userService.alterPassword(u, user.getPassword());

			return "redirect:/login";

		} catch (UserInvalid e) {
			ra.addFlashAttribute("msgErro2", e.getMessage());
		}

		return "redirect:/alterar-senha";

	}

	@GetMapping("/login")
	public String viewLogin() {
		return "login";
	}

	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/main-center")
	public String viewProdCenter(Model model) {
		List<Product> list = productService.listProducts();
		model.addAttribute("products", list);

		return "main-center";
	}

	@GetMapping("/pedidos/{id}")
	public String viewHistor(@PathVariable Integer id, Model model) {
		List<Request> list = requestService.listRequests(id);
		model.addAttribute("request", list);

		return "historic";
	}

	@GetMapping("/meus-dados")
	public String viewDados() {
		return "settings";
	}

	@GetMapping("/info-pessoa/{id}")
	public String viewInfo(Model model, @PathVariable Integer id) {
		User user = userService.findById(id);
		System.out.println(user);
		model.addAttribute("user", user);

		return "settings_personal_information";
	}

	@GetMapping("/credencial/{id}")
	public String viewCred(Model model, @PathVariable Integer id) {
		User user = userService.findById(id);
		System.out.println(user);
		model.addAttribute("user", user);

		return "settings_credentials";
	}

	@PostMapping("/salvarUser")
	public String createUser(User user, String passwordValid, RedirectAttributes ra, Model model) {

		try {
			userService.validSaveUser(user, passwordValid);

			user.setPassword(userService.criptografarPassword(user));
			userService.save(user);
			userService.emailSend(user);

			return "redirect:/";

		}
		catch (UserInvalid e) {
			ra.addFlashAttribute("msgError", e.getMessage());
		}

		return "redirect:/cadastro";

	}

	@PostMapping("/logar")
	public String logarUser(Model model, @RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes red) {

		try {
			User logado = this.userService.login(email, password);
			session.setAttribute("logado", logado);
			return "redirect:/main-center";

		} catch (UserNonexistentException e) {
			model.addAttribute("msgErro", e.getMessage());
		} catch (UserInvalid e) {
			model.addAttribute("msgErro", e.getMessage());
		}

		return "/login";

	}

	@PostMapping("/updateuser-info")
	public String updateUser(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		userService.updateData(user);

		return "redirect:/meus-dados";
	}

	@PostMapping("/updateuser-credencial")
	public String updateUserC(@ModelAttribute User user, String passwordValid, Model model) {

		if (this.userDAO.existsByEmail(user.getEmail()) && !user.getPassword().equals(passwordValid)) {
			// red.addFlashAttribute(); mensagem
			// red.addFlashAttribute("", user); Retornar o resto
			return "redirect:/credencial/{id}";

		} else if (this.userDAO.existsByEmail(user.getEmail())) {
			// red.addFlashAttribute(); mensagem
			// red.addFlashAttribute("", user); Retornar o resto
			return "redirect:/credencial/{id}";

		} else if (!user.getPassword().equals(passwordValid)) {
			// red.addFlashAttribute(); mensagem
			// red.addFlashAttribute("", user); Retornar o resto
			return "redirect:/credencial/{id}";
		}

		model.addAttribute("user", user);
		userService.updateDataC(user);

		return "redirect:/meus-dados";
	}

}
