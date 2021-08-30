package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.CreateOrderDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineData;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IOrderService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.OrderStatus;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{

	private IOrderRepository _orderRepository;
	
	private IMedicineRepository _medicineRepository;
	
	@Autowired
	public OrderService(IOrderRepository orderRepository, IMedicineRepository medicineRepository) {
		this._orderRepository = orderRepository;
		this._medicineRepository = medicineRepository;
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
	public List<OrderDTO> findAllOrdersForPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		List<Order> allOrders = _orderRepository.findAll();
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		Date currentDate = new Date(System.currentTimeMillis());
		
		
		for (Order order : allOrders) {
			if (order.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {
				if (order.getOfferDeadline().before(currentDate) && order.getOrderStatus() != OrderStatus.FINISHED) {
					order.setOrderStatus(OrderStatus.PROCESSED);
					_orderRepository.save(order);
				}
				
				if (order.getOrderStatus() == OrderStatus.PROCESSED) {
					String deadline = new SimpleDateFormat("dd.MM.yyyy.").format(order.getOfferDeadline());
					OrderDTO orderDTO = new OrderDTO(order.getOrderId(), deadline, order.getPharmacyAdministrator().getUserId(), order.getPharmacyAdministrator().getFirstName() + " " + order.getPharmacyAdministrator().getLastName(), order.getOrderStatus());
					list.add(orderDTO);
				}
			}
		}
		return list;
	}
	
	
	@Override
	public List<OrderDTO> findAllOrdersWaitingOfferForPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		List<Order> allOrders = _orderRepository.findAll();
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		Date currentDate = new Date(System.currentTimeMillis());
		
		
		for (Order order : allOrders) {
			if (order.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {
				if (order.getOfferDeadline().before(currentDate) && order.getOrderStatus() != OrderStatus.FINISHED) {
					order.setOrderStatus(OrderStatus.PROCESSED);
					_orderRepository.save(order);
				}
				
				if (order.getOrderStatus() == OrderStatus.WAITING_OFFER) {
					String deadline = new SimpleDateFormat("dd.MM.yyyy.").format(order.getOfferDeadline());
					OrderDTO orderDTO = new OrderDTO(order.getOrderId(), deadline, order.getPharmacyAdministrator().getUserId(), order.getPharmacyAdministrator().getFirstName() + " " + order.getPharmacyAdministrator().getLastName(), order.getOrderStatus());
					list.add(orderDTO);
				}
			}
		}
		return list;
	}
	
	@Override
	public List<OrderDTO> findAllFinishedOrdersForPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		List<Order> allOrders = _orderRepository.findAll();
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		Date currentDate = new Date(System.currentTimeMillis());
		for (Order order : allOrders) {
			if (order.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {	
				if (order.getOfferDeadline().before(currentDate) && order.getOrderStatus() != OrderStatus.FINISHED) {
					order.setOrderStatus(OrderStatus.PROCESSED);
					_orderRepository.save(order);
				}
				if (order.getOrderStatus() == OrderStatus.FINISHED) {
					String deadline = new SimpleDateFormat("dd.MM.yyyy.").format(order.getOfferDeadline());
					OrderDTO orderDTO = new OrderDTO(order.getOrderId(), deadline, order.getPharmacyAdministrator().getUserId(), order.getPharmacyAdministrator().getFirstName() + " " + order.getPharmacyAdministrator().getLastName(), order.getOrderStatus());
					list.add(orderDTO);
				}
			}
		}
		return list;
	}
	
	@Override
	public List<Long> findMedicineItemIdsByOrderId(Long orderId) {
		return _orderRepository.findMedicineItemIdsByOrderId(orderId);
	}

	public void createOrder(CreateOrderDTO createOrderDTO) {
		List<MedicineData> medicineDatas = (List<MedicineData>) createOrderDTO;
		Order order = new Order();
		
		for (MedicineData m : medicineDatas) {
			MedicineItem medicineItem = new MedicineItem();
			medicineItem.setMedicine(_medicineRepository.getOne(m.getMedicineId()));
			medicineItem.setQuantity(m.getQuantity());
		}
		order.setOrderStatus(OrderStatus.WAITING_OFFER);
		// order.setOfferDeadline();
		// order.setPharmacy();
		// order.setPharmacyAdministrator();
	}
	
}
