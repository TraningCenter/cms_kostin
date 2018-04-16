package kostin.dao;

import kostin.mappers.ImageMapper;
import kostin.mappers.PostImageMapper;
import kostin.mappers.PostMapper;
import kostin.model.Image;
import kostin.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PostDao {

    private PostMapper postMapper;

    private ImageDao imageDao;

    private PostImageDao postImageDao;


    @Autowired
    public PostDao(PostMapper postMapper, ImageDao imageDao, PostImageDao postImageDao) {
        this.postMapper = postMapper;
        this.imageDao = imageDao;
        this.postImageDao = postImageDao;
    }

    public Post getPost(int id){
        return  postMapper.getPostById(id);
    }

    public Integer createPost(Post post){

        postMapper.createPost(post);


        for(Image img :post.getImages()){
            imageDao.createImage(img);
            postImageDao.createPostImage(post.getId(),img.getImageId());
        }

        return post.getId();

    }

    //TODO return
    public void updatePost(Post post){

        postMapper.updatePost(post);

        postImageDao.deleteLinkByPostId(post.getId());

        for (Image img :post.getImages()){
            imageDao.updateImage(img);
          postImageDao.createPostImage(post.getId(),img.getImageId());
        }


    }

    //TODO return
    public void deletePost(int id){

        postMapper.deletePostById(id);

        postImageDao.deleteLinkByPostId(id);

    }




}
