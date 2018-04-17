package kostin.services;

import kostin.model.*;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ConversationScoped
public class PostService implements Serializable{


    private PostManagerService postManagerService;

    private ContentManagerService contentManagerService;

    public PostService() {
    }

    @Inject
    public PostService(PostManagerService postManagerService, ContentManagerService contentManagerService) {
        this.postManagerService = postManagerService;
        this.contentManagerService = contentManagerService;
    }

    public PostUI getPost(int id){

        PostUI post=new PostUI();
        PostPm postPm =postManagerService.getPost(id);
        System.out.println(postPm.getTitle());
        System.out.println(postPm.getImages());
        post.setTitle(postPm.getTitle());
        post.setText(contentManagerService.getText(postPm.getTextId()).getContent());
        List<ImageUI> images = new ArrayList<>();
        for(ImagePm imagePm:postPm.getImages()){
            ImageUI image=new ImageUI();
            image.setPosition(imagePm.getPosition());
            image.setBytes(contentManagerService.getImage(imagePm.getCmId()));
            images.add(image);
        }
        post.setImages(images);
        return post;

    }

    public Integer createPost(PostUI post){
        int textId = contentManagerService.createText(new TextCm(null,post.getText()));
        List<ImagePm> images = new ArrayList<>();
        for(ImageUI image:post.getImages()){
            ImagePm imagePm = new ImagePm();
            imagePm.setPosition(image.getPosition());
            imagePm.setCmId(contentManagerService.createImage(image.getBytes()));
            images.add(imagePm);
        }
        PostPm postPm = new PostPm(null,new Date(),post.getTitle(),textId,images);
        return postManagerService.createPost(postPm);
    }

    private void test(){

        List<ImagePm> imagePms = new ArrayList<>();
        for (int i=0;i<3;i++){
            ImagePm imagePm = new ImagePm(i+13,i+6);
            imagePms.add(imagePm);
        }
        PostPm post = new PostPm(null,new Date(), "title",7,imagePms);
        int id =postManagerService.createPost(post);
        System.out.println(id);
        System.out.println( postManagerService.getPost(id).toString());
    }

    public PostManagerService getPostManagerService() {
        return postManagerService;
    }

    public void setPostManagerService(PostManagerService postManagerService) {
        this.postManagerService = postManagerService;
    }
}
