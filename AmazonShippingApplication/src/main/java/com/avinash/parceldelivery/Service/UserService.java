package com.avinash.parceldelivery.Service;

import java.util.concurrent.ExecutionException;

import com.avinash.parceldelivery.Model.Order;
import com.avinash.parceldelivery.Model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

public class UserService {

	public User getUserDetails(String username) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(Constants.USER_COLLECTION).document(username);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        User user = null;

        if(document.exists()) {
        	user = document.toObject(User.class);
            return user;
        }else {
            return null;
        }
	}
	
	public String saveUserDetails(User user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(Constants.USER_COLLECTION).document(user.getUsername()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
	}
}
