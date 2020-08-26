package com.avinash.parceldelivery.Service;

import com.avinash.parceldelivery.Model.Order;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class OrderService {

	public String saveOrderDetails(Order order) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(Constants.ORDER_COLLECTION)
				.document(order.getOrder_id()).set(order);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public List<Order> getAllOrders() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		List<Order> orders = new ArrayList<Order>();
		// asynchronously retrieve all documents
		ApiFuture<QuerySnapshot> future = dbFirestore.collection(Constants.ORDER_COLLECTION).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			orders.add(document.toObject(Order.class));
			System.out.println(document.getId() + " => " + document.toObject(Order.class));
		}
		return orders;
	}

	public Order getOrderDetails(String name) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(Constants.ORDER_COLLECTION).document(name);
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		DocumentSnapshot document = future.get();

		Order order = null;

		if (document.exists()) {
			order = document.toObject(Order.class);
			return order;
		} else {
			return null;
		}
	}

	public List<String> updateBatchOrders(List<Order> orderList) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		WriteBatch batch = dbFirestore.batch();
		CollectionReference colRef = dbFirestore.collection(Constants.ORDER_COLLECTION);

		for (Order o : orderList) {
			DocumentReference docRef = colRef.document(o.getOrder_id());
			batch.set(docRef, o);
		}
		ApiFuture<List<WriteResult>> future = batch.commit();
		List<String> output = new ArrayList<>();
		for (WriteResult result : future.get()) {
			output.add(result.getUpdateTime().toString());
			
		}
		return output;
	}

	public String updateOrderDetails(Order order) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(Constants.ORDER_COLLECTION)
				.document(order.getOrder_id()).set(order);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deleteOrder(String orderid) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		// TODO: Add condition to check if document with id exists, Return appropriate
		// message
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(Constants.ORDER_COLLECTION).document(orderid)
				.delete();

		return "Document with Order ID " + orderid + " has been deleted";
	}

}