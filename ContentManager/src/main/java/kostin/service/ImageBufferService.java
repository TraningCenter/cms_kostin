package kostin.service;

import kostin.dao.ImageRepository;
import kostin.model.Image;
import kostin.model.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

@Service
public class ImageBufferService {

    private ImageCompareService imageCompareService;

    private GoogleDriveService driveService;

    private ImageRepository imageRepository;

    private BlockingQueue<Image> images = new PriorityBlockingQueue();

    @Autowired
    public ImageBufferService(ImageCompareService imageCompareService, GoogleDriveService driveService, ImageRepository imageRepository) {
        this.imageCompareService = imageCompareService;
        this.driveService = driveService;
        this.imageRepository = imageRepository;
    }

    public Integer addToBuffer(Image image) {
        try {

            String hash = imageCompareService.getHash(image.getBytes());
            image.setHash(hash);
            images.put(image);
            return trySave();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Integer checkForUnique(String hash) {
        List<ImageEntity> images = imageRepository.findByHash(hash);
        if (images.size() > 0) {
            return 0;
        } else {
            return images.get(0).getId();
        }
    }

    private Integer trySave() {
        try {
            Image image = images.take();
            Integer id=checkForUnique(image.getHash());
            if (id==0) {
                ImageEntity imageEntity = new ImageEntity();
                imageEntity.setHash(image.getHash());
                imageEntity.setName(image.getName());
                saveInDB(imageEntity);
                imageEntity.setGoogleId(saveOnDrive(image));
                return saveInDB(imageEntity);
            } else {
                return id;
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Integer saveInDB(ImageEntity image) {
        image = imageRepository.save(image);
        return image.getId();
    }

    private String saveOnDrive(Image image) {
        String googleId = driveService.upload(image.getBytes());
        return googleId;
    }

}
