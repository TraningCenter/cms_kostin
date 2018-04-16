package kostin.views;

import kostin.services.ImageParserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class Bean {

    @Inject
    private ImageParserService imageParserService;


    private String text="NAmed";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print(){
        System.out.println(text);
        imageParserService.parsePost(text);




    }



    public ImageParserService getImageParserService() {
        return imageParserService;
    }

    public void setImageParserService(ImageParserService imageParserService) {
        this.imageParserService = imageParserService;
    }
}
