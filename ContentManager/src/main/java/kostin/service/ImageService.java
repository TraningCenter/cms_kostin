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

    public Integer createImage(Image imageDto){

        return imageBufferService.addToBuffer(imageDto);
    }

    public byte[] getImage(Integer id){
       return driveService.download(imageRepository.findOne(id).getGoogleId());
    }

}
