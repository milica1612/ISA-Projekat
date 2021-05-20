package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IOrderService;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private IOrderRepository _orderRepository;
	
	@Override
	public Order findById(Long id) {
		return _orderRepository.findById(id).orElse(null);
	}

	@Override
	public List<Order> findAll() {
		return _orderRepository.findAll();
	}

	@Override
	public Order save(Order order) {
		return _orderRepository.save(order);
	}

}
