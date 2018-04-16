package kostin.service;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import kostin.config.GoogleDriveConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;

@Service
public class GoogleDriveService {

    private GoogleDriveConfig driveConfig;

    private Drive drive;

    @Autowired
    public GoogleDriveService(GoogleDriveConfig driveConfig) {
        this.driveConfig = driveConfig;
    }

    @PostConstruct
    public void initDrive() {
        try {
            drive = driveConfig.getDriveService();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //TODO remove comments
    public String upload(byte[] bytes) {
        try {
            File fileMetadata = new File();
            fileMetadata.setName("photo.jpg");
          //  java.io.File mediaFile = new java.io.File("D:\\Valakas.jpg");
            InputStreamContent mediaContent =
                    new InputStreamContent("image/jpeg",
                            new BufferedInputStream(new ByteArrayInputStream(bytes)));
            mediaContent.setLength(bytes.length);

            Drive.Files.Create request = drive.files().create(fileMetadata, mediaContent);
            //  request.getMediaHttpUploader().setProgressListener(new CustomProgressListener());
            return request.execute().getId();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public byte[] download(String fileID){
        try{
           // OutputStream out = new FileOutputStream("D:\\disktest\\picture.jpeg");

            Drive.Files.Get request = drive.files().get(fileID);
            InputStream stream = request.executeMediaAsInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            org.apache.commons.io.IOUtils.copy(stream, baos);
            byte[] bytes =  baos.toByteArray();
            return  bytes;

        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }



    public void getList(){
        try{
        FileList result = drive.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.size() == 0) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
             //   drive.files().delete(file.getId());
            }
        }
    }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
