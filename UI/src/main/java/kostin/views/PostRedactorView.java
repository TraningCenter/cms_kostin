package kostin.views;

import kostin.model.PostPm;
import kostin.model.PostUI;
import kostin.services.ImageBuilderService;
import kostin.services.ImageParserService;
import kostin.services.PostService;

import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ConversationScoped
public class PostRedactorView implements Serializable{

    @Inject
    private ImageParserService imageParserService;

    @Inject
    private PostService postService;



    private String text;

    private String title;


    public void createPost(){
        PostUI post = imageParserService.parsePost(text);
        post.setTitle(title);
        int id =postService.createPost(post);
        System.out.println(id);
    }





    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageParserService getImageParserService() {
        return imageParserService;
    }

    public void setImageParserService(ImageParserService imageParserService) {
        this.imageParserService = imageParserService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }
}
