package com.loggit.LibraryManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.loggit.LibraryManagement.Dao.*;
import com.loggit.LibraryManagement.Entity.*;

@Controller
public class SearchBookController {
	@GetMapping("loggit/HomeBook/Search")
	public String searchBook(Model model, @RequestParam("search") String search, HttpSession session) {
		User user = (User) session.getAttribute("user");
		BookDao bd = new BookDao();
		List<Book> li = new ArrayList<Book>();
		li = bd.getBookByName(search);
		model.addAttribute("txtS", search);
		model.addAttribute("books", li);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "HomeShop";
	}
	
	@GetMapping("loggit/home/search")
	public String searchHomeBook(Model model, @RequestParam("search") String search, HttpSession session) {
		User user = (User) session.getAttribute("user");
		BookDao bd = new BookDao();
		List<Book> li = new ArrayList<Book>();
		li = bd.getBookByName(search);
		model.addAttribute("txtS", search);
		model.addAttribute("books", li);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "Home";
	}
}
