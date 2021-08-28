package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Order;

@Service
public interface IOrderService {

	Order findById(Long id);
	
	List<Order> findAll();

	Order save(Order order);
	
	List<OrderDTO> findAllOrdersForPharmacy();
	
	List<OrderDTO> findAllOrdersWaitingOfferForPharmacy();
	
	List<OrderDTO> findAllFinishedOrdersForPharmacy();
}
