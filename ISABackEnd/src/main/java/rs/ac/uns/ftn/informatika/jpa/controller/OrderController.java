package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.CreateOrderDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineData;
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
	public ResponseEntity<List<OrderDTO>> findAllOrdersForPharmacy() {
		List<OrderDTO> listOrderDTOs =  _orderService.findAllOrdersForPharmacy();
		return new ResponseEntity<List<OrderDTO>>(listOrderDTOs, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path="/waitingOfferForPharmacy")
	public ResponseEntity<List<OrderDTO>> findAllOrdersWaitingOfferForPharmacy() {
		List<OrderDTO> listOrderDTOs =  _orderService.findAllOrdersWaitingOfferForPharmacy();
		return new ResponseEntity<List<OrderDTO>>(listOrderDTOs, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path="/finishedOrdersForPharmacy")
	public ResponseEntity<List<OrderDTO>> findAllFinishedOrdersForPharmacy() {
		List<OrderDTO> listOrderDTOs =  _orderService.findAllFinishedOrdersForPharmacy();
		return new ResponseEntity<List<OrderDTO>>(listOrderDTOs, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path="/findMedicineItemIdsByOrderId/{orderId}")
	public List<Long> findMedicineItemIdsByOrderId(@PathVariable Long orderId) {
		return _orderService.findMedicineItemIdsByOrderId(orderId);
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@PostMapping(value="/createOrder")
	public ResponseEntity<Boolean> create(@RequestBody CreateOrderDTO createOrderDTO) {
		
			List<MedicineData> medicineItemData = new ArrayList<MedicineData>();
			for (int i = 0; i < createOrderDTO.getKeys1().size(); i++) {
				MedicineData mData1 = new MedicineData(createOrderDTO.getKeys1().get(i), createOrderDTO.getValues1().get(i)); 
				medicineItemData.add(mData1);
			}
			List<MedicineData> newMedicineItemData = new ArrayList<MedicineData>();
			for (int i = 0; i < createOrderDTO.getKeys2().size(); i++) {
				MedicineData mData2 = new MedicineData(createOrderDTO.getKeys2().get(i), createOrderDTO.getValues2().get(i)); 
				newMedicineItemData.add(mData2);
			}
			
			_orderService.createOrder(medicineItemData, newMedicineItemData, Long.parseLong(createOrderDTO.getPharmacyAdminId()), createOrderDTO.getPharmacyId(),
					createOrderDTO.getOfferDeadline());
			
            return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
