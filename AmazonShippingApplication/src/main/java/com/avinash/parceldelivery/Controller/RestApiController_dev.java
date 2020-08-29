/**
 * This is a RestController class for exposing the REST endpoints.
 * @author Avinash Tingre
 */
package com.avinash.parceldelivery.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.parceldelivery.Model.Mail;
import com.avinash.parceldelivery.Model.Order;
import com.avinash.parceldelivery.Model.User;
import com.avinash.parceldelivery.Service.ExcelToDatabase;
import com.avinash.parceldelivery.Service.MailService;
import com.avinash.parceldelivery.Service.OrderService;
import com.avinash.parceldelivery.Service.UserService;

@RestController
@Profile("dev")
@RequestMapping("/ShippingApplication")
public class RestApiController_dev {
	private static final Logger LOG = LoggerFactory.getLogger(RestApiController_dev.class);

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@Autowired
	ExcelToDatabase dataService;
	
	@Autowired
	MailService mailService;
	
	List<Order> sampleList = new CopyOnWriteArrayList<Order>();
	
	@RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
	public Order getOrderDetails(@RequestParam String orderid) throws InterruptedException, ExecutionException {
		Order order = new Order();
		for (Order o : sampleList) {
			if(orderid.equals(o.getOrder_id())) {
				order = o;
			}
		}
		return order;
		//return orderService.getOrderDetails(orderid);
	}

	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public List<Order> getAllOrders() throws InterruptedException, ExecutionException {
		return sampleList;
		//return orderService.getAllOrders();	
	}

	
	@RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
	public User getUserDetails(@RequestParam String username) throws InterruptedException, ExecutionException {
		//TODO: Remote below User object while firebase testing
		User user = new User();
		user.setUsername("avinash");
		user.setPassword("avinash123");
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		user.setAuthorities(roles);
		
		return user;
		
		//return userService.getUserDetails(username);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
		/*User user = new User();
		user.setUsername("avinash");
		user.setPassword("avinash123");
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(false);
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		user.setAuthorities(roles);
		*/
		return userService.saveUserDetails(user);
		
	}

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String sendMail(@RequestBody Mail mail) throws InterruptedException, ExecutionException {
		
		return mailService.sendMail(mail);
		
	}

	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(@RequestBody Order order) throws InterruptedException, ExecutionException {
		/*
		Order order = new Order();
		order.setOrder_id("406-7487687-8756316");
		order.setOrder_item_id("26053826341739");
		order.setPurchase_date("2020-08-16T11:08:18+00:00");
        order.setPayments_date("2020-08-16T11:08:18+00:00");
        order.setReporting_date("2020-08-16T11:46:13+00:00");
        order.setPromise_date("2020-08-18T18:29:59+00:00");
        order.setDays_past_promise("-2");
        order.setBuyer_email("zdhq0x5mw5j6tfz@marketplace.amazon.in");
        order.setBuyer_name("Mariaselvaraj");
        order.setBuyer_phone_number("9940636594");
        order.setSku("MS25");
        order.setProduct_name("Kejia Tactile Switch Micro Push To on Button - Set of 25 Pcs");
        order.setQuantity_purchased(1);
        order.setQuantity_shipped(0);
        order.setQuantity_to_ship(1);
        order.setShip_service_level("Standard");
        order.setShip_service_name("Std IN MFN2");
        order.setRecipient_name("Std IN MFN2");
        order.setShip_address_1("F1, Plat no 82, Grand Eternia,");
        order.setShip_address_2("2nd street Senthil nagar , Seevaram, Perungudi");
        order.setShip_city("CHENNAI");
        order.setShip_state("TAMIL NADU");
        order.setShip_postal_code(600096);
        order.setShip_country("IN");
        order.setIs_business_order(false);
        order.setIs_prime(false);
        order.setIs_sold_by_ab(false);
		*/
		sampleList.add(order);
		return "Order added";
		//return orderService.saveOrderDetails(order);
    }

	@RequestMapping(value = "/loadData", method = RequestMethod.POST)
    public long loadData(  ) throws InterruptedException, ExecutionException, IOException {
		
		return dataService.mergeExcelDataToDB();
    }

	@RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(  ) throws InterruptedException, ExecutionException, IOException {
		
		return "DEV - REST working!";
    }

	@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody Order order  ) throws InterruptedException, ExecutionException {
        for (Order o: sampleList) {
        	if(o.getOrder_id().equals(order.getOrder_id())) {
        		sampleList.remove(o);
                sampleList.add(order);
        	}
        }
        return "Order updated";
		//return orderService.updateOrderDetails(order);
    }
	
	@RequestMapping(value = "/updateBatchOrders", method = RequestMethod.PUT)
    public List<String> updateBatchOrders(@RequestBody List<Order> orders  ) throws InterruptedException, ExecutionException {
		
		sampleList.clear();
		sampleList.addAll(orders);
		List<String> output = new ArrayList<String>();
        for (Order o: orders) {
        	output.add(o.getOrder_id()+" updated.");
        }
        return output;
		//return orderService.updateBatchOrders(orders);
    }

	@RequestMapping(value = "/deleteOrder", method = RequestMethod.DELETE)
    public String deleteOrder(@RequestParam String orderid) throws InterruptedException, ExecutionException{
		for (Order o: sampleList) {
        	if(o.getOrder_id().equals(orderid)) {
        		sampleList.remove(o);
        	}
        }
		return "Order Deleted";
		//return orderService.deleteOrder(orderid);
    }

}
