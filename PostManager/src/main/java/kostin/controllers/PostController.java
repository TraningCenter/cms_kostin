package kostin.controllers;

import kostin.dto.ImageDto;
import kostin.dto.PostDto;
import kostin.mappers.ImageMapper;
import kostin.mappers.PostMapper;
import kostin.model.Image;
import kostin.model.Post;
import kostin.services.PostService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/post/{id}")
    public PostDto getPost(@PathVariable Integer id) {//REST Endpoint.

        PostDto post = postService.getPost(id);

        return post;
    }



    @RequestMapping(value = "/post", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Integer addPost(@RequestBody PostDto post) {

        int id =postService.createPost(post);
        return id;

    }


    @RequestMapping(value = "/post", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void updatePost(@RequestBody PostDto post) {

         postService.updatePost(post);
    }


    @RequestMapping(value = "/post/{id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
    }
}

