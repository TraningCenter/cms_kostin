package kostin.services;

import kostin.model.ImageUI;
import kostin.model.PostUI;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Named
@ConversationScoped
public class ImageBuilderService implements Serializable{

    public String buildPostString(PostUI post){
        String text=post.getText();
        StringBuilder postString = new StringBuilder();
        int position=0;
        int index=0;
        int startText=0;
        while (index!=-1) {
            index = text.indexOf("<img src=\"data:image/", index);
            if (index!=-1) {
                String imageText = getImageByPos(post.getImages(),position);
                position++;
               index = post.getText().indexOf(',', index);
               index++;
               postString.append(post.getText().substring(startText,index));
               postString.append(imageText);
               startText=index;
            }else{
                postString.append(post.getText().substring(startText,post.getText().length()));
            }
        }
        return postString.toString();
    }

    private String getImageByPos(List<ImageUI> images,int position){

        for (ImageUI img:images) {
            if(img.getPosition()==position){
                return translateToString(img.getBytes());
            }
        }
        return null;
    }

    private String translateToString(byte[] imageByte){
        try {
            String imageString;
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageByte);
            return imageString;



        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}

