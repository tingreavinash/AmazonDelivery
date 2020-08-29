package com.avinash.parceldelivery.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.avinash.parceldelivery.Model.Order;
import com.monitorjbl.xlsx.StreamingReader;
import com.monitorjbl.xlsx.impl.StreamingCell;

@Service
public class ExcelToDatabase {
	private static final Logger LOG = LoggerFactory.getLogger(ExcelToDatabase.class);
	public static List<String> row_values = new ArrayList<String>();
	public static List<String> nested_list = new ArrayList<String>();
	
	@Autowired
	OrderService orderService;
	@Value("${key.ORDER_EXCEL_FILE}")
	private String ORDER_EXCEL_FILE; 
	
	public long mergeExcelDataToDB() throws IOException {
		
		long total_records = 0;
		InputStream fis = null;
		Workbook workbook = null;
		Sheet sheet;
		try {
			File file = new File(ORDER_EXCEL_FILE);
			fis = new FileInputStream(file);
			workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(fis);
			sheet = workbook.getSheetAt(0);

			int startRow = 1;
			int endRow = sheet.getLastRowNum();
			
			
			LOG.info("Data loading started: " + new Date());
			
			for (Row r : sheet) {
				
				if (r.getRowNum() >= startRow && r.getRowNum() <= endRow) {
					Order order = new Order();

					row_values = getListFromRow(r);
					
					order = createObjectFromlist(row_values, total_records);
					String result = orderService.saveOrderDetails(order);
					LOG.info("Result "+r.getRowNum()+" :"+result);
					
					total_records++;
					row_values.clear();
				}
				
			}
			LOG.info("Data loading finished: " + new Date());
			//saveSummaryInDB();
		} catch (FileNotFoundException ex) {
			LOG.error("File not found !!\n" + ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (workbook != null) {
				workbook.close();
			}

			if (fis != null) {
				fis.close();
			}
			
		}
		return total_records;
	}
	
	@SuppressWarnings("deprecation")
	private static Order createObjectFromlist(List<String> row_values, long count) {

		Order order = new Order();
		
		order.setOrder_id(row_values.get(Constants.order_id ));
		order.setOrder_item_id(row_values.get(Constants.order_item_id ));
		order.setPurchase_date(row_values.get(Constants.purchase_date ));
		order.setPayments_date(row_values.get(Constants.payments_date ));
		order.setReporting_date(row_values.get(Constants.reporting_date ));
		order.setPromise_date(row_values.get(Constants.promise_date ));
		order.setDays_past_promise(row_values.get(Constants.days_past_promise ));
		order.setBuyer_email(row_values.get(Constants.buyer_email ));
		order.setBuyer_name(row_values.get(Constants.buyer_name ));
		order.setBuyer_phone_number(row_values.get(Constants.buyer_phone_number ));
		order.setSku(row_values.get(Constants.sku ));
		order.setProduct_name(row_values.get(Constants.product_name ));
		
		order.setQuantity_purchased( Integer.parseInt(row_values.get(Constants.quantity_purchased)  ));
		order.setQuantity_shipped(Integer.parseInt(row_values.get(Constants.quantity_shipped) ));
		order.setQuantity_to_ship(Integer.parseInt(row_values.get(Constants.quantity_to_ship) ));
		order.setShip_service_level(row_values.get(Constants.ship_service_level ));
		order.setShip_service_name(row_values.get(Constants.ship_service_name ));
		order.setRecipient_name(row_values.get(Constants.recipient_name ));
		order.setShip_address_1(row_values.get(Constants.ship_address_1 ));
		order.setShip_address_2(row_values.get(Constants.ship_address_2 ));
		order.setShip_address_3(row_values.get(Constants.ship_address_3 ));
		order.setShip_city(row_values.get(Constants.ship_city ));
		order.setShip_state(row_values.get(Constants.ship_state ));
		order.setShip_postal_code(Integer.parseInt(row_values.get(Constants.ship_postal_code) ));
		order.setShip_country(row_values.get(Constants.ship_country ));
		order.setPayment_method(row_values.get(Constants.payment_method ));
		order.setCod_collectible_amount(row_values.get(Constants.cod_collectible_amount ));
		order.setAlready_paid(row_values.get(Constants.already_paid ));
		order.setPayment_method_fee(row_values.get(Constants.payment_method_fee ));
		order.setIs_business_order( Boolean.parseBoolean( row_values.get(Constants.is_business_order) ));
		order.setPurchase_order_number(row_values.get(Constants.purchase_order_number ));
		order.setPrice_designation(row_values.get(Constants.price_designation ));
		order.setIs_prime(Boolean.parseBoolean(row_values.get(Constants.is_prime) ));
		order.setFulfilled_by(row_values.get(Constants.fulfilled_by ));
		order.setShipment_status(row_values.get(Constants.shipment_status ));
		order.setIs_sold_by_ab(Boolean.parseBoolean(row_values.get(Constants.is_sold_by_ab) ));

		return order;
	}

	
	private static List<String> getListFromRow(Row row) {
		nested_list.clear();
		
		for (int i = 0; i < 36; i++) {
			
			
			Cell c = row.getCell(i);

			if (c == null) {
				c = new StreamingCell(i, row.getRowNum(), true);
			}
			
			
			if (c.getColumnIndex() == 1 || c.getColumnIndex() == 9) {
				Object o = c.getNumericCellValue();
				nested_list.add(new BigDecimal(o.toString()).toPlainString());
				continue;
			}

			if (c.getColumnIndex() == 2 || c.getColumnIndex() == 3 || c.getColumnIndex() == 4 || c.getColumnIndex() == 5) {
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
				if (c.getCellType() == CellType.NUMERIC && c.getDateCellValue() != null) {
					String date = df.format(c.getDateCellValue());
					nested_list.add(date);
				} else if (c.getCellType() == CellType.STRING && c.getStringCellValue() != "") {
					nested_list.add(c.getStringCellValue());
				} else {
					nested_list.add("-");
				}
				continue;
			}
			if (c.getCellType() == CellType.NUMERIC) {
				int val = (int) c.getNumericCellValue();
				nested_list.add(String.valueOf(val));

			} else if (c.getCellType() == CellType.STRING && c.getStringCellValue() != "") {
				nested_list.add(c.getStringCellValue());

			} else {
				nested_list.add("-");
			}

		}

		
		return nested_list;

	}


}
