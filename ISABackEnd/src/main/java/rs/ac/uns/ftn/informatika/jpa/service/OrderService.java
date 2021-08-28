package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IOrderService;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{

	private IOrderRepository _orderRepository;
	
	@Autowired
	public OrderService(IOrderRepository orderRepository) {
		this._orderRepository = orderRepository;
	}
	
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
	
	@Override
	public List<Order> findAllOrdersForPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		List<Order> allOrders = _orderRepository.findAll();
		List<Order> list = new ArrayList<Order>();
		for (Order order : allOrders) 
			if (order.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId())
				list.add(order);
			
		return list;
	}

}
