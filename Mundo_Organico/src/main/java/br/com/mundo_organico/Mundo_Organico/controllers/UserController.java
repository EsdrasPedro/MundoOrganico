package br.com.mundo_organico.Mundo_Organico.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mundo_organico.Mundo_Organico.models.User;
import br.com.mundo_organico.Mundo_Organico.repositories.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

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

	@GetMapping("/meus-dados")
	public String viewDados() {
		return "settings";
	}

	@GetMapping("/info-pessoa")
	public String viewInfo() {
		return "settings_personal_information";
	}

	@GetMapping("/credencial")
	public String viewCredencial() {
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

		this.userDAO.save(user);
		return "index";
	}

	@PostMapping("/logar")
	public String logarUser(String email, String password, HttpSession session, RedirectAttributes red) {

		User logado = this.userDAO.findByEmailAndPassword(email, password);

		if (logado.equals(null)) {
			// red.addFlashAttribute() mensagem
			return "redirect:/login";

		} else {
			session.setAttribute("logado", logado);
			return "redirect:/main-center";
		}
	}

//	@PostMapping("/updateuser-info/{id}")
//	public String updateUserinfo(@PathVariable("id") Integer id, User user, Model model) {
//		Optional<User> updateUser = this.userDAO.findById(id);
//      
//      model.addAttribute("user", updateUser.get());
//		
//		return "settings";
//	}

//	@PostMapping("/updateuser-credencial/{id}")
//	public String updateUserCredencial(@PathVariable("id") Integer id, Model model) {
//		Optional<User> updateUser = this.userDAO.findById(id);
//	
//		return "settings";
//	}

}
