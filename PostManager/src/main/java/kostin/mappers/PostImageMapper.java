package kostin.mappers;

import kostin.model.Image;
import kostin.model.Post;
import kostin.model.PostImage;

import java.util.List;

public interface PostImageMapper {

    void createPostImage(PostImage postImage);

    void deleteLinkByPostId (Integer id);

}
