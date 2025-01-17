package com.avinash.parceldelivery.Service;

import com.avinash.parceldelivery.Model.Order;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class OrderService {

    public static final String COL_NAME="orders";

    public String saveOrderDetails(Order order) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(order.getOrder_id()).set(order);
        
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Order getOrderDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Order patient = null;

        if(document.exists()) {
            patient = document.toObject(Order.class);
            return patient;
        }else {
            return null;
        }
    }
    
    

    public String updateOrderDetails(Order order) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(order.getOrder_id()).set(order);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteOrder(String orderid) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        //TODO: Add condition to check if document with id exists, Return appropriate message
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(orderid).delete();
        
        return "Document with Order ID "+orderid+" has been deleted";
    }

}