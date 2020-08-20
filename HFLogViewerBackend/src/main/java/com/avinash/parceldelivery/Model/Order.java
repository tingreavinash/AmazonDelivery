package com.avinash.parceldelivery.Model;

public class Order {
	private String order_id;
	private String order_item_id;
	private String purchase_date;
	private String payments_date;
	private String reporting_date;
	private String promise_date;
	private String days_past_promise;
	private String buyer_email;
	private String buyer_name;
	private String buyer_phone_number;
	private String sku;
	private String product_name;
	private int quantity_purchased;
	private int quantity_shipped;
	private int quantity_to_ship;
	private String ship_service_level;
	private String ship_service_name;
	private String recipient_name;
	private String ship_address_1;
	private String ship_address_2;
	private String ship_address_3;
	private String ship_city;
	private String ship_state;
	private long ship_postal_code;
	private String ship_country;
	private String payment_method;
	private String cod_collectible_amount;
	private String already_paid;
	private String payment_method_fee;
	private boolean is_business_order;
	private String purchase_order_number;
	private String price_designation;
	private boolean is_prime;
	private String fulfilled_by;
	private String shipment_status;
	private boolean is_sold_by_ab;
	
	private String tracking_id;
	private String courier_code;
	private String record_created_by;
	private String record_last_modified;
	
	
	public String getRecord_created_by() {
		return record_created_by;
	}
	public void setRecord_created_by(String record_created_by) {
		this.record_created_by = record_created_by;
	}
	public String getRecord_last_modified() {
		return record_last_modified;
	}
	public void setRecord_last_modified(String record_last_modified) {
		this.record_last_modified = record_last_modified;
	}
	public String getCourier_code() {
		return courier_code;
	}
	public void setCourier_code(String courier_code) {
		this.courier_code = courier_code;
	}
	public String getTracking_id() {
		return tracking_id;
	}
	public void setTracking_id(String tracking_id) {
		this.tracking_id = tracking_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(String order_item_id) {
		this.order_item_id = order_item_id;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getPayments_date() {
		return payments_date;
	}
	public void setPayments_date(String payments_date) {
		this.payments_date = payments_date;
	}
	public String getReporting_date() {
		return reporting_date;
	}
	public void setReporting_date(String reporting_date) {
		this.reporting_date = reporting_date;
	}
	public String getPromise_date() {
		return promise_date;
	}
	public void setPromise_date(String promise_date) {
		this.promise_date = promise_date;
	}
	public String getDays_past_promise() {
		return days_past_promise;
	}
	public void setDays_past_promise(String days_past_promise) {
		this.days_past_promise = days_past_promise;
	}
	public String getBuyer_email() {
		return buyer_email;
	}
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_phone_number() {
		return buyer_phone_number;
	}
	public void setBuyer_phone_number(String buyer_phone_number) {
		this.buyer_phone_number = buyer_phone_number;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity_purchased() {
		return quantity_purchased;
	}
	public void setQuantity_purchased(int quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}
	public int getQuantity_shipped() {
		return quantity_shipped;
	}
	public void setQuantity_shipped(int quantity_shipped) {
		this.quantity_shipped = quantity_shipped;
	}
	public int getQuantity_to_ship() {
		return quantity_to_ship;
	}
	public void setQuantity_to_ship(int quantity_to_ship) {
		this.quantity_to_ship = quantity_to_ship;
	}
	public String getShip_service_level() {
		return ship_service_level;
	}
	public void setShip_service_level(String ship_service_level) {
		this.ship_service_level = ship_service_level;
	}
	public String getShip_service_name() {
		return ship_service_name;
	}
	public void setShip_service_name(String ship_service_name) {
		this.ship_service_name = ship_service_name;
	}
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	public String getShip_address_1() {
		return ship_address_1;
	}
	public void setShip_address_1(String ship_address_1) {
		this.ship_address_1 = ship_address_1;
	}
	public String getShip_address_2() {
		return ship_address_2;
	}
	public void setShip_address_2(String ship_address_2) {
		this.ship_address_2 = ship_address_2;
	}
	public String getShip_address_3() {
		return ship_address_3;
	}
	public void setShip_address_3(String ship_address_3) {
		this.ship_address_3 = ship_address_3;
	}
	public String getShip_city() {
		return ship_city;
	}
	public void setShip_city(String ship_city) {
		this.ship_city = ship_city;
	}
	public String getShip_state() {
		return ship_state;
	}
	public void setShip_state(String ship_state) {
		this.ship_state = ship_state;
	}
	public long getShip_postal_code() {
		return ship_postal_code;
	}
	public void setShip_postal_code(long ship_postal_code) {
		this.ship_postal_code = ship_postal_code;
	}
	public String getShip_country() {
		return ship_country;
	}
	public void setShip_country(String ship_country) {
		this.ship_country = ship_country;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getCod_collectible_amount() {
		return cod_collectible_amount;
	}
	public void setCod_collectible_amount(String cod_collectible_amount) {
		this.cod_collectible_amount = cod_collectible_amount;
	}
	public String getAlready_paid() {
		return already_paid;
	}
	public void setAlready_paid(String already_paid) {
		this.already_paid = already_paid;
	}
	public String getPayment_method_fee() {
		return payment_method_fee;
	}
	public void setPayment_method_fee(String payment_method_fee) {
		this.payment_method_fee = payment_method_fee;
	}
	public boolean getIs_business_order() {
		return is_business_order;
	}
	public void setIs_business_order(boolean is_business_order) {
		this.is_business_order = is_business_order;
	}
	public String getPurchase_order_number() {
		return purchase_order_number;
	}
	public void setPurchase_order_number(String purchase_order_number) {
		this.purchase_order_number = purchase_order_number;
	}
	public String getPrice_designation() {
		return price_designation;
	}
	public void setPrice_designation(String price_designation) {
		this.price_designation = price_designation;
	}
	public boolean getIs_prime() {
		return is_prime;
	}
	public void setIs_prime(boolean is_prime) {
		this.is_prime = is_prime;
	}
	public String getFulfilled_by() {
		return fulfilled_by;
	}
	public void setFulfilled_by(String fulfilled_by) {
		this.fulfilled_by = fulfilled_by;
	}
	public String getShipment_status() {
		return shipment_status;
	}
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}
	public boolean getIs_sold_by_ab() {
		return is_sold_by_ab;
	}
	public void setIs_sold_by_ab(boolean is_sold_by_ab) {
		this.is_sold_by_ab = is_sold_by_ab;
	}
	
	
	
	
}