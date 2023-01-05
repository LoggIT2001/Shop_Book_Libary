package com.loggit.LibraryManagement.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.loggit.LibraryManagement.Dao.UserDao;
import com.loggit.LibraryManagement.Entity.*;

@Controller
public class UserController {
		
	@GetMapping("/loggit/login")
	public String formlogin(Model model) {
		model.addAttribute("user", new User());
		return "Login";
	}
	@PostMapping("/loggit/loginn")
	public String loginn(Model model, @RequestParam("username") String username, @RequestParam("pass") String pass, RedirectAttributes redirectAttributes, HttpSession session) {
		String message = "Incorrect account or password!";
		String mess2 = "Password can not be empty!";
		String mess3 = "Username can not be empty!";
		UserDao d = new UserDao();
		User u = new User();
		u = d.getUserByUsername(username);
		System.out.print(u);
		if(username.equals("") && pass.equals("")) {
			model.addAttribute("mess2", mess2);
			model.addAttribute("mess3", mess3);
			return "Login";
		}else if(pass.equals("")) {
			model.addAttribute("mess2", mess2);
			return "Login";
		}else if(username.equals("")) {
			model.addAttribute("mess3", mess3);
			return "Login";
		}
		if(u.getUsername()==null || u.getPass()==null) {
			model.addAttribute("message", message);
			return "Login";
		}else {
			if(u.getRole()==1) {
				session.setAttribute("user", u);
				return "redirect:/loggit/books";
			}else {
				session.setAttribute("user", u);
				return "redirect:/loggit/HomeBook";
			}
			
		}
	}
	
	@GetMapping("loggit/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "Register";
	}
	
	@PostMapping("loggit/registeruser")
	public String registeruser(Model model,@RequestParam("user") String username, @RequestParam("email") String email, 
			@RequestParam("phone") String phone, @RequestParam("pass") String pass, @RequestParam("confirmpass") String confirmpass) {
		String mess1 = "User already exist!";
		String mess2 = "Password cannot be different from ComfirmPass";
		
		UserDao d = new UserDao();
		User u = new User();
		u = d.getUserByUsername(username);
		if(username.equals("") || email.equals("") || phone.equals("") || pass.equals("") || confirmpass.equals("")) {
			return "Register";
		}
		if(!pass.equals(confirmpass)) {
			model.addAttribute("message2", mess2);
			return "Register";
		}else {
			if(u.getUsername()==null) {
				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPhone(phone);
				user.setPass(pass);
				user.setRole(0);
				d.inserUser(user);
				return "redirect:/loggit/login";
			}else {
				model.addAttribute("message1", mess1);
				return "Register";
			}
		}
	}
}
