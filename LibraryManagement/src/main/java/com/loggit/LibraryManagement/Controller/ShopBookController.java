package com.loggit.LibraryManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.loggit.LibraryManagement.Dao.*;
import com.loggit.LibraryManagement.Entity.*;

@Controller
public class ShopBookController {
	@GetMapping("/loggit/HomeBook")
	public String getAllBook(Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Book> li = new ArrayList<Book>();
		BookDao bd = new BookDao();
		li = bd.getAllBook();
		model.addAttribute("books", li);
		model.addAttribute("name", user.getFullname());
//		redirectAttributes.addFlashAttribute("user",user);
		User u = user;
//		model.addAttribute("user",u);
		session.setAttribute("user", u);
		System.out.println(u);
		return "HomeShop";
	}
	
	@GetMapping("loggit/shop_book/{id}")
	public String getShopBookById(Model model,  @PathVariable String id, HttpSession session) {
		int a = 2;
		User user = (User) session.getAttribute("user");
		BookDao d = new BookDao();
		CategoryDao cd = new CategoryDao();
		RatingDao rd = new RatingDao();
		List<Category> li = cd.getAllCategory();
		List<Rating> li_ra = rd.rating(id);
		Book b = d.getBookById(Integer.parseInt(id));
		model.addAttribute("idb", Integer.parseInt(id));
		System.out.print(b);
		model.addAttribute("aa", a);
		model.addAttribute("book", b);
		model.addAttribute("cate", li);
		model.addAttribute("rat", li_ra);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "BookShopDetail";
	}
	
	@GetMapping("/loggit/HomeBook/{cate}")
	public String getBookByCate(Model model, RedirectAttributes redirectAttributes, @PathVariable String cate, HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Book> li = new ArrayList<Book>();
		BookDao bd = new BookDao();
		li = bd.getBookByCate(cate);
		model.addAttribute("txtS", cate);
		model.addAttribute("books", li);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "HomeShop";
	}
	
	@PostMapping("/loggit/detail/rating/{id}")
	public String vote(Model model, @PathVariable int id, @RequestParam("rate") int rate, @RequestParam("comment") String comment, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		RatingDao rd = new RatingDao();
		rd.voting(id, user.getUsername(), rate, comment);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/shop_book/" + id;
	}
	
	@GetMapping("/loggit/addcart/{id}")
	public String addCart(Model model, @PathVariable("id") int id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		CartDao cd = new CartDao();
		cd.addCart(id, user.getId());
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/HomeBook";
	}
	@PostMapping("/loggit/addtocart/{id}")
	public String addToCart(Model model, @PathVariable("id") int id, HttpSession session, @RequestParam("quantity") int quantity) {
		User user = (User) session.getAttribute("user");
		CartDao cd = new CartDao();
		cd.addtoCart(id, user.getId(), quantity);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/shop_book/" + id;
	}
	
	@GetMapping("/loggit/cart")
	public String Cart(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		CartDao cd = new CartDao();
		BookDao bd = new BookDao();
		List<Cart> li = cd.allCartByU(user.getId());
		float totalprice = 0;
		for(Cart c: li) {
			float total = c.getBook().getPrice() * c.getQuantity();
			totalprice += total;
		}
		float tot = totalprice + totalprice*10/100;
		model.addAttribute("book_cart", li);
		model.addAttribute("name", user.getUsername());
		model.addAttribute("total", totalprice);
		model.addAttribute("total_price", tot);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		session.setAttribute("li_c", li);
		return "Cart";
	}
	
	@GetMapping("/loggit/cart/delete/{id}")
	public String deleteCart(Model model, HttpSession session, @PathVariable("id") int id) {
		User user = (User) session.getAttribute("user");
		CartDao cd = new CartDao();
		cd.deteleCartByB(id, user.getId());
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/cart";
	}
	
	
}
