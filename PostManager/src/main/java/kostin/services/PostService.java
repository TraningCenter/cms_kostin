package kostin.services;

import kostin.dao.PostDao;
import kostin.dto.ImageDto;
import kostin.dto.PostDto;
import kostin.dtoMappers.PostDtoMapper;
import kostin.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {

    private PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public PostDto getPost(int id){

        PostDto postDto = PostDtoMapper.INSTANCE.postToPostDto(postDao.getPost(id));
        if(postDto.getImages()==null){
            postDto.setImages(new ArrayList<ImageDto>());
        }
        return postDto;
    }

    public Integer createPost(PostDto postDto){

        Post post = PostDtoMapper.INSTANCE.postDtoToPost(postDto);

        return  postDao.createPost(post);

    }

    public void updatePost(PostDto postDto){

        Post post = PostDtoMapper.INSTANCE.postDtoToPost(postDto);

        postDao.updatePost(post);

    }

    public void deletePost(Integer postId){

        postDao.deletePost(postId);

    }
}
