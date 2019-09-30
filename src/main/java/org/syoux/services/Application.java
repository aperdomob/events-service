package org.syoux.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) throws Exception {
    List<FirebaseApp> firebaseApps = FirebaseApp.getApps();

    if (firebaseApps.isEmpty()) {
      String url = Application.getFirebaseUrl();
      String databaseUrl = "https://" + System.getenv("EVENT_PROJECT_NAME") + ".firebaseio.com/";

      URLConnection connection = new URL(url).openConnection();

      InputStream serviceAccount = connection.getInputStream();

      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl(databaseUrl)
          .build();

      FirebaseApp.initializeApp(options);
    }

    SpringApplication.run(Application.class, args);
  }

  private static String getFirebaseUrl() {
    String firebaseUrl = System.getenv("FIREBASE_URL");
    String googleCredentialsUrl = System.getenv("GOOGLE_CREDENTIALS_URI");
    String storeFirebaseToken = System.getenv("STORE_FIREBASE_TOKEN");

    return firebaseUrl + googleCredentialsUrl + "?alt=media&token=" + storeFirebaseToken;
  }
}
