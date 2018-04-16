package kostin.dao;

import kostin.mappers.ImageMapper;
import kostin.model.Image;
import kostin.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao {

    private ImageMapper imageMapper;

    @Autowired
    public ImageDao(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public Image getImage(int id){
        return imageMapper.getImageById(id);
    }


    public Integer createImage(Image image){

        return  imageMapper.createImage(image);


    }

    public void updateImage(Image image){

        imageMapper.updateImage(image);

    }

    public void deleteImage(int id){

        imageMapper.deleteImageById(id);

    }


}
