package kostin.dao;

import kostin.mappers.PostImageMapper;
import kostin.model.Image;
import kostin.model.PostImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostImageDao {

    private PostImageMapper postImageMapper;

    @Autowired
    public PostImageDao(PostImageMapper postImageMapper) {
        this.postImageMapper = postImageMapper;
    }

    public void createPostImage(int postId, int imageId){

        PostImage postImage = new PostImage();

        postImage.setPostId(postId);

        postImage.setImageId(imageId);

       postImageMapper.createPostImage(postImage);

    }


    public void deleteLinkByPostId(int id){

        postImageMapper.deleteLinkByPostId(id);

    }
}
