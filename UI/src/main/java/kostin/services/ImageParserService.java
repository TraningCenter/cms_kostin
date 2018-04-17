package kostin.services;

import kostin.model.ImageUI;
import kostin.model.PostUI;
import kostin.views.PostRedactorView;
import sun.misc.BASE64Decoder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ConversationScoped
public class ImageParserService implements Serializable{


    public PostUI parsePost(String postString){
        PostUI post = new PostUI();
        List<ImageUI> images = new ArrayList<>();
        int position=0;
        StringBuilder text = new StringBuilder();
        int index=0;
        while (index!=-1&&index<postString.length()) {
            int startText = index;
            index = postString.indexOf("<img src=\"data:image/", index);
            if (index!=-1) {
                ImageUI image = new ImageUI();
                index = postString.indexOf(',', index);
                int endText = index+1;
                text.append(postString.substring(startText,endText));
                int startImage = index + 1;
                index = postString.indexOf('>', index);
                text.append("\">");
                int endImage = index - 1;
                String imageString = postString.substring(startImage, endImage);
                image.setBytes( translateToBytes(imageString));
                image.setPosition(position);
                images.add(image);
                position++;
                index++;
            }
            if (startText<postString.length()&&index==-1){

                text.append(postString.substring(startText,postString.length()));
            }
        }
        post.setImages(images);
        post.setText(text.toString());
        return post;
    }

    private byte[] translateToBytes(String imageString){
        try {

            byte[] imageByte;
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
           return imageByte;



        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
