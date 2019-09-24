package br.com.ifrn.swv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ifrn.swv.model.Usuario;
import br.com.ifrn.swv.service.SessionService;
import br.com.ifrn.swv.service.UsuarioService;


@Controller
public class IndexController {
	
	//@GetMapping("/")
	//public String index() {
	//	return "index";
	//}
	
	@Autowired
	private UsuarioService serviceUsuario;
	@Autowired
	private SessionService<Usuario> serviceSession;

	@PostMapping("/home") 
	public String home() { 
		
		Usuario usuarioByEmail = serviceUsuario.getEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		
		serviceSession.criarSession("usuario", usuarioByEmail);
		
		System.out.println("TELA HOME");
		return "home";
	} 
	 
	@GetMapping("/")
	public String index() {
		System.out.println("TELA LOGIN");
		serviceSession.clearSession();
		return "login";
	}
	
	@GetMapping("/entrar")
	public String entrar() {
		return "login";
	}
}
