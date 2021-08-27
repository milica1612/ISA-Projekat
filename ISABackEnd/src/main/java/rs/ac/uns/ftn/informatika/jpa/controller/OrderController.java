package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.service.OrderService;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class OrderController {
	
	private OrderService _orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this._orderService = orderService;
	}
	
	@GetMapping(value = "/{id}")
	public Order findById(@PathVariable Long id) {
		return _orderService.findById(id);
	}
	
	@GetMapping(value = "/allOrders")
	public List<Order> findAll() {
		return _orderService.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path="/forPharmacy")
	public List<OrderDTO> findAllOrdersForPharmacy() {
		return _orderService.findAllOrdersForPharmacy();
	}
	
}
