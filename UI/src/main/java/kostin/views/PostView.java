package kostin.views;

import kostin.model.PostUI;
import kostin.services.ImageBuilderService;
import kostin.services.PostService;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ConversationScoped
public class PostView implements Serializable {

    @Inject
    private PostService postService;

    @Inject
    private ImageBuilderService imageBuilderService;

    private Integer id;

    private String title;

    private String text;

    public void getPost(){

       PostUI post = postService.getPost(id);
       text=imageBuilderService.buildPostString(post);
       title=post.getTitle();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
