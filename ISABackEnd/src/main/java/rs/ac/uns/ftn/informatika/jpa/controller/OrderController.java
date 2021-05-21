package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderController {

	@Autowired
	private OrderService _orderService;
	
	@GetMapping(value = "/{id}")
	public Order findById(@PathVariable Long id) {
		return _orderService.findById(id);
	}
	
	@GetMapping(value = "/allOrders")
	public List<Order> findAll() {
		return _orderService.findAll();
	}
	
}
