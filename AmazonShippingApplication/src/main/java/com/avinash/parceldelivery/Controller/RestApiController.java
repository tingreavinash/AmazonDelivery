/**
 * This is a RestController class for exposing the REST endpoints.
 * @author Avinash Tingre
 */
package com.avinash.parceldelivery.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/ShippingApplication")
public class RestApiController {
	private static final Logger LOG = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@Autowired
	ExcelToDatabase dataService;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
	public Order getOrderDetails(@RequestParam String orderid) throws InterruptedException, ExecutionException {
	    Order order = new Order();
	    if("406-7487687-8756316".equals(orderid)) {
		    order.setOrder_id("406-7487687-8756316" );
		    order.setOrder_item_id("26053826341739" );
		    order.setPurchase_date("2020-08-16T11:08:18+00:00" );
		    order.setPayments_date("2020-08-16T11:08:18+00:00" );
		    order.setReporting_date("2020-08-16T11:46:13+00:00" );
		    order.setPromise_date("2020-08-18T18:29:59+00:00" );
		    order.setDays_past_promise("-2" );
		    order.setBuyer_email("zdhq0x5mw5j6tfz@marketplace.amazon.in" );
		    order.setBuyer_name("Mariaselvaraj" );
		    order.setBuyer_phone_number("9940636594" );
		    order.setSku("MS25" );
		    order.setProduct_name("Kejia Tactile Switch Micro Push To on Button - Set of 25 Pcs" );
		    order.setQuantity_purchased( 1  );
		    order.setQuantity_shipped(0 );
		    order.setQuantity_to_ship(1 );
		    order.setShip_service_level("Standard" );
		    order.setShip_service_name("Std IN MFN2" );
		    order.setRecipient_name("Maria selvaraj D" );
		    order.setShip_address_1("F1, Plat no 82, Grand Eternia," );
		    order.setShip_address_2("2nd street Senthil nagar , Seevaram, Perungudi" );
		    order.setShip_address_3(null );
		    order.setShip_city("CHENNAI" );
		    order.setShip_state("TAMIL NADU" );
		    order.setShip_postal_code(600096);
		    order.setShip_country("IN" );
		    order.setPayment_method(null );
		    order.setCod_collectible_amount(null );
		    order.setAlready_paid(null );
		    order.setPayment_method_fee(null );
		    order.setIs_business_order(  false );
		    order.setPurchase_order_number(null );
		    order.setPrice_designation(null );
		    order.setIs_prime(false );
		    order.setFulfilled_by(null );
		    order.setShipment_status(null );
		    order.setIs_sold_by_ab(true );
	    	
	    }

	    return order;

		//TODO: Remove below comment while firebase integration
		//return orderService.getOrderDetails(orderid);
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
    public String createUser() throws InterruptedException, ExecutionException {
		User user = new User();
		user.setUsername("avinash");
		user.setPassword("avinash123");
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(false);
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		user.setAuthorities(roles);
		
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
		return orderService.saveOrderDetails(order);
    }

	@RequestMapping(value = "/loadData", method = RequestMethod.POST)
    public long loadData(  ) throws InterruptedException, ExecutionException, IOException {
		
		return dataService.mergeExcelDataToDB();
    }

	@RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(  ) throws InterruptedException, ExecutionException, IOException {
		
		return "REST working!";
    }

	@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody Order order  ) throws InterruptedException, ExecutionException {
        return orderService.updateOrderDetails(order);
    }


	@RequestMapping(value = "/deleteOrder", method = RequestMethod.DELETE)
    public String deleteOrder(@RequestParam String orderid) throws InterruptedException, ExecutionException{
        return orderService.deleteOrder(orderid);
    }

}
