package com.avinash.parceldelivery.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseInitialize {
	private static final Logger LOG = LoggerFactory.getLogger(FirebaseInitialize.class);
	
	@Value("${key.SERVICE_ACCOUNT_FILE}")
	private String SERVICE_ACCOUNT_FILE; 
    
	@Value("${key.DATABASE_URL}")
	private String DATABASE_URL; 
    
	//TODO: remove below comment while firebase testing
	@PostConstruct
    public void initialize() {
        try {
        	
        	LOG.info("Service account file: "+SERVICE_ACCOUNT_FILE);
        	LOG.info("Database URL: "+DATABASE_URL);
        	
        	FileInputStream serviceAccount =
                    new FileInputStream(SERVICE_ACCOUNT_FILE);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(DATABASE_URL)
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}