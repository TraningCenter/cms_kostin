package kostin.service;

import kostin.dao.ImageRepository;
import kostin.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    private ImageBufferService imageBufferService;

    private GoogleDriveService driveService;

    @Autowired
    public ImageService(ImageRepository imageRepository, ImageBufferService imageBufferService, GoogleDriveService driveService) {
        this.imageRepository = imageRepository;
        this.imageBufferService = imageBufferService;
        this.driveService = driveService;
    }

    public Integer createImage(byte[] bytes){

        Image image= new Image();
        image.setBytes(bytes);
        Integer id=  imageBufferService.addToBuffer(image);
        System.out.println("id "+id);
        return id;
    }

    public byte[] getImage(Integer id){
       return driveService.download(imageRepository.findOne(id).getGoogleId());
    }

}
