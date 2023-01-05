package com.loggit.LibraryManagement.Controller;

import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.loggit.LibraryManagement.Entity.*;
import com.loggit.LibraryManagement.Dao.*;

@Controller
public class BookController {	
	
//	@GetMapping("/loggit/home")
//	public String getBook(Model model) {
//		BookDao d = new BookDao();
//		List<Book> li = d.getAllBook();
//		model.addAttribute("books", li);
//		return "Home";
//	}
	
	@GetMapping("/loggit/books")
	public String getAllBook(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		BookDao d = new BookDao();
		List<Book> li = d.getAllBook();
		model.addAttribute("books", li);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "Home";
	}
	@GetMapping("loggit/books/{id}")
	public String getBookById(Model model, @PathVariable String id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int a = 2;
		BookDao d = new BookDao();
		CategoryDao cd = new CategoryDao();
		List<Category> li = cd.getAllCategory();
		Book b = d.getBookById(Integer.parseInt(id));
		model.addAttribute("idb", Integer.parseInt(id));
		System.out.print(b);
		model.addAttribute("aa", a);
		model.addAttribute("book", b);
		model.addAttribute("cate", li);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "BookDetail";
	}
	@GetMapping("loggit/books/addBook")
	public String addBook(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Book b = new Book();
		int id = -1;
		int a = 1;
		CategoryDao cd = new CategoryDao();
		List<Category> li = cd.getAllCategory();
		model.addAttribute("cate", li);
		model.addAttribute("idb", id);
		model.addAttribute("aa", a);
		model.addAttribute("book", b);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "BookDetail";
	}
	
	@PostMapping("loggit/books/add/{id}")
	public String addnewbook(Model model,@Valid Book book, BindingResult bindingResult, @RequestParam("image") MultipartFile file, @PathVariable String id, RedirectAttributes redirectAttributes, HttpSession session){ 
		User user = (User) session.getAttribute("user");
		boolean theAreErrors = bindingResult.hasErrors();
		if(theAreErrors) {
			model.addAttribute("idb", id);
			int a = 1;
			model.addAttribute("aa", a);
			CategoryDao cd = new CategoryDao();
			List<Category> li = cd.getAllCategory();
			model.addAttribute("cate", li);
			model.addAttribute("name", user.getFullname());
			session.setAttribute("user", user);
			return "BookDetail";
		}
		BookDao d = new BookDao();
		System.out.print(book);
		d.insertBook(book, file);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/books";
	}
	
	@GetMapping("loggit/books/edit/{id}")
	public String getBook(Model model, @PathVariable String id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int a = 3;
		BookDao d = new BookDao();
		Book b = d.getBookById(Integer.parseInt(id));
		model.addAttribute("idb", Integer.parseInt(id));
		System.out.print(b);
		model.addAttribute("aa", a);
		model.addAttribute("book", b);
		CategoryDao cd = new CategoryDao();
		List<Category> li = cd.getAllCategory();
		model.addAttribute("cate", li);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "BookDetail";
	}
	
	@PutMapping("loggit/books/edit/save/{id}")
	public String update(Model model,@Valid Book book, BindingResult bindingResult, @RequestParam("image") MultipartFile file, @PathVariable String id, RedirectAttributes redirectAttributes, HttpSession session) {
		User user = (User) session.getAttribute("user");
		boolean theAreErrors = bindingResult.hasErrors();
		if(theAreErrors) {
			model.addAttribute("idb", id);
			int a = 3;
			model.addAttribute("aa", a);
			CategoryDao cd = new CategoryDao();
			List<Category> li = cd.getAllCategory();
			model.addAttribute("cate", li);
			model.addAttribute("name", user.getFullname());
			session.setAttribute("user", user);
			return "BookDetail";
		}
		BookDao d = new BookDao();
		d.updateBook(book, file);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/books";
	}
	
	@GetMapping("loggit/books/confirm/{id}")
	public String confirm(Model model, @PathVariable String id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("id", id);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "Confirm";
	}
	
	@GetMapping("/loggit/books/confirm/books")
	public String home(Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/books";
	}
	
	@DeleteMapping("loggit/books/confirm/delete/{id}")
	public String delete(Model model, @PathVariable String id, RedirectAttributes redirectAttributes, HttpSession session) {
		User user = (User) session.getAttribute("user");
		BookDao d = new BookDao();
		d.deleteBook(Integer.parseInt(id));
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/books";
	}
}
