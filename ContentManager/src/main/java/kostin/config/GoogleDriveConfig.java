package kostin.config;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.PlusScopes;
import com.google.api.services.plus.model.Activity;
import com.google.common.io.Files;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;



@Component
public class GoogleDriveConfig {
    /**
     * Be sure to specify the name of your application. If the application name is {@code null} or
     * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
     */
    private static final String APPLICATION_NAME = "CMS";

    /** E-mail address of the service account. */
    private static final String SERVICE_ACCOUNT_EMAIL = "okostin13@gmail.com"
            + "https://code.google.com/apis/console/?api=plus into SERVICE_ACCOUNT_EMAIL in "
            + GoogleDriveConfig.class;

    /** Global instance of the HTTP transport. */
    private  HttpTransport HTTP_TRANSPORT ;

    /** Global instance of the JSON factory. */
    private  JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static Plus plus;

    public Credential config() {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

// Build service account credential.
            URL resource = this.getClass().getClassLoader().getResource("my_project.json");
            File file = new File(resource.toURI());
            FileInputStream input = new FileInputStream(file);
            GoogleCredential credential = GoogleCredential.fromStream(input)
                    .createScoped(Collections.singleton(DriveScopes.DRIVE));
            //TODO delete if not necessary
          /*  plus = new Plus.Builder(HTTP_TRANSPORT, jsonFactory, credential)
                    .setApplicationName(APPLICATION_NAME).build();*/
        return credential;

        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public  Drive getDriveService() throws IOException {
        Credential credential = config();
        return new Drive.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

}
