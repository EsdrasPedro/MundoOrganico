package br.com.mundo_organico.Mundo_Organico.controllers;

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
import br.com.mundo_organico.Mundo_Organico.services.UserService;
import br.com.mundo_organico.Mundo_Organico.models.User;
import br.com.mundo_organico.Mundo_Organico.repositories.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}

	@GetMapping("/cadastro")
	public String viewUsuario() {
		return "register";
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
	public String viewProdCenter() {
		return "main-center";
	}

	@GetMapping("/frutas")
	public String viewCatFrut() {
		return "main-fruit";
	}

	@GetMapping("/verduras")
	public String viewCatVeget() {
		return "main-vegetable";
	}

	@GetMapping("/hortalicas")
	public String viewCatHort() {
		return "main-vegetable-Hort";
	}

	@GetMapping("/temperos")
	public String viewCatSeas() {
		return "main-seasonings";
	}

	@GetMapping("/compra")
	public String viewShoppBag() {
		return "shopping_bag";
	}

	@GetMapping("/meus-dados")
	public String viewDados() {
		return "settings";
	}

	@GetMapping("/credencial")
	public String viewCredencial() {
		return "settings_credentials";
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
	public String createUser(User user, String passwordValid, RedirectAttributes red) {

		if (user.getName().trim().isEmpty() || user.getCellphone().trim().isEmpty() || user.getEmail().trim().isEmpty()
				|| user.getPassword().trim().isEmpty()) {
			// red.addFlashAttribute(); mensagem
			return "redirect:/cadastro";
		}

		if (this.userDAO.existsByEmail(user.getEmail()) && !user.getPassword().equals(passwordValid)) {
			// red.addFlashAttribute(); mensagem
			// red.addFlashAttribute("", user); Retornar o resto
			return "redirect:/cadastro";

		} else if (this.userDAO.existsByEmail(user.getEmail())) {
			// red.addFlashAttribute(); mensagem
			// red.addFlashAttribute("", user); Retornar o resto
			return "redirect:/cadastro";

		} else if (!user.getPassword().equals(passwordValid)) {
			// red.addFlashAttribute(); mensagem
			// red.addFlashAttribute("", user); Retornar o resto
			return "redirect:/cadastro";
		}

		user.setPassword(userService.criptografarPassword(user));
		userService.save(user);
		userService.emailSend(user);
		return "index";
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
