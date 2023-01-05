package com.loggit.LibraryManagement.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loggit.LibraryManagement.Dao.*;
import com.loggit.LibraryManagement.Entity.*;
import com.loggit.LibraryManagement.Entity.User;

@Controller
public class OrderController {
	@PostMapping("/loggit/order")
	public String order(Model model, HttpSession session, @RequestParam("address") String address) {
		User user = (User) session.getAttribute("user");	
		OrderDao od = new OrderDao();
		List<Cart> li = (List<Cart>)session.getAttribute("li_c");
		float totalprice = 0;
		int quantity = 0;
		for(Cart c: li) {
			float total = c.getBook().getPrice() * c.getQuantity();
			totalprice += total;
			quantity += c.getQuantity();
		}
		totalprice = totalprice + totalprice*10/100;
		String status = "Not Delivery";
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		od.insertOrder(user.getId(), date, quantity, totalprice, status, address);
		int id_order = od.idOrderMax();
		int quan = 0;
		for(Cart c: li) {
			quan += c.getQuantity();
			float total = c.getBook().getPrice() * c.getQuantity();
			od.insertDetailOrder(id_order, c.getBook().getId(), user.getId(), c.getQuantity(), total);
		}
		CartDao cd = new CartDao();
		cd.deleteCart(user.getId());
		model.addAttribute("quan_cart", quan);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		session.setAttribute("li_c", li);
		return "redirect:/loggit/HomeBook";
	}
	
	@GetMapping("/loggit/listorder")
	public String listOrder(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Cart> li = (List<Cart>)session.getAttribute("li_c");
		OrderDao od = new OrderDao();
		List<Order> lio = new ArrayList<Order>();
		lio = od.getAllOrder(user.getId());
		model.addAttribute("liorder", lio);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		session.setAttribute("li_c", li);
		return "Order";
	}
	
	@GetMapping("loggit/order/{id}")
	public String getOrderByid(Model model, HttpSession session, @PathVariable("id") int id) {
		User user = (User) session.getAttribute("user");
		List<Cart> li = (List<Cart>)session.getAttribute("li_c");
		OrderDao od = new OrderDao();
		Order o = od.getOrder(id);
		List<DetailOrder> lio = od.getAllDetailOrder(id);
		model.addAttribute("listDetail", lio);
		model.addAttribute("client", user);
		model.addAttribute("address", o.getAddress());
		model.addAttribute("quantity", o.getQuantity());
		model.addAttribute("total_price", o.getTotalprice());
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		session.setAttribute("li_c", li);
		return "DetailOrder";
	}
	
	@GetMapping("/loggit/deleteorder/{id}")
	public String deleteOrder(Model model, HttpSession session, @PathVariable("id") int id) {
		User user = (User) session.getAttribute("user");
		List<Cart> li = (List<Cart>)session.getAttribute("li_c");
		OrderDao od = new OrderDao();
		od.deleteOrder(id);
		od.deleteDetailOrder(id);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		session.setAttribute("li_c", li);
		return "redirect:/loggit/listorder";
	}
	
	@GetMapping("/loggit/checkorder")
	public String checkOrder(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		OrderDao od = new OrderDao();
		List<Order> lio = new ArrayList<Order>();
		lio = od.getAllOrderAd();
		model.addAttribute("liorder", lio);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "CheckOrder";
	}
	
	@GetMapping("/loggit/accept/{id}")
	public String acceptOrder(Model model, HttpSession session, @PathVariable("id") int id) {
		User user = (User) session.getAttribute("user");
		OrderDao od = new OrderDao();
		String status = "Delivered";
		od.updateOrder(id, status);
		model.addAttribute("name", user.getFullname());
		session.setAttribute("user", user);
		return "redirect:/loggit/checkorder";
	}
}
