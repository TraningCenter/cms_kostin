package kostin.mappers;

import kostin.model.Image;
import kostin.model.Post;

public interface ImageMapper {

        Image getImageById(Integer id);

        Integer createImage(Image image);

        void updateImage(Image image);

        void deleteImageById (Integer id);

}
