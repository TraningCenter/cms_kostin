package kostin.services;



import kostin.model.TextCm;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;


@Named
@ConversationScoped
public class ContentManagerService implements Serializable {

    private String uri="http://localhost:8084/";

    public byte[] getImage(Integer id){
        return ClientBuilder.newClient().target(uri+"contentManager/image/"+id).request().get(byte[].class);
    }

    public Integer createImage(byte[] bytes){
        Invocation invocation = ClientBuilder.newClient().target(uri+"contentManager/image").request().buildPost(Entity.entity(bytes, MediaType.APPLICATION_OCTET_STREAM_TYPE));
        Response response = invocation.invoke();
        return  response.readEntity(Integer.class);
    }

    public TextCm getText(Integer id){
        return ClientBuilder.newClient().target(uri+"contentManager/text/"+id).request().get(TextCm.class);
    }

    public Integer createText(TextCm textCm){
        Invocation invocation = ClientBuilder.newClient().target(uri+"contentManager/text").request().buildPost(Entity.entity(textCm, MediaType.APPLICATION_JSON_TYPE));
        Response response = invocation.invoke();
        return  response.readEntity(Integer.class);
    }

    public void updateText(TextCm textCm){
            Invocation invocation = ClientBuilder.newClient().target(uri+"contentManager/text").request().buildPut(Entity.entity(textCm, MediaType.APPLICATION_JSON_TYPE));
            Response response = invocation.invoke();
        }

    public void deleteText(Integer id){
        Invocation invocation = ClientBuilder.newClient().target(uri+"contentManager/text/"+id).request().buildDelete();
        invocation.invoke();
    }


}
