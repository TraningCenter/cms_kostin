package kostin.services;

import kostin.model.ImagePm;
import kostin.model.PostPm;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;

@Named
@ConversationScoped
public class PostManagerService implements Serializable {


    private String uri;



    @PostConstruct
    private void getProp() {
     /*   Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream("classpath:uri.properties");




            // load a properties file
            prop.load(input);

            // get the property value and print it out
            uri=prop.getProperty("uri");


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } */
     uri="http://localhost:8084/";
    }
    public PostPm getPost(Integer id){
       PostPm post = ClientBuilder.newClient().target(uri+"postManager/post/"+id).request().get(PostPm.class);

       return post;
    }

    public Integer createPost(PostPm post){
        Invocation invocation = ClientBuilder.newClient().target(uri+"postManager/post").request().buildPost(Entity.entity(post, MediaType.APPLICATION_JSON));
        Response response = invocation.invoke();
        return  response.readEntity(Integer.class);
    }

    public void deletePost(Integer id){
        Invocation invocation = ClientBuilder.newClient().target(uri+"postManager/post/"+id).request().buildDelete();
        invocation.invoke();
    }

    public void updatePost(PostPm post){
        Invocation invocation = ClientBuilder.newClient().target(uri+"postManager/post").request().buildPut(Entity.entity(post,MediaType.APPLICATION_JSON));
        invocation.invoke();
    }

}
