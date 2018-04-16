package kostin.services;

import kostin.views.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ImageParserService {

   //@ManagedProperty("#{bean}")
   // @Inject
    private Bean bean;

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public void test(){

        System.out.println("text");
      //  bean.print();
    }

    public void parsePost(String post){
        List<Integer> positions = new ArrayList<>();
        int index=0;
        while (index!=-1) {
            //  int pos = post.indexOf("<img src=\"data:image/jpeg;base64,", index);
            index = post.indexOf("<img src=\"data:image/", index);
            if (index!=-1) {
                System.out.println(index);
                index = post.indexOf(',', index);
                System.out.println(index);
                int start = index + 1;
                index = post.indexOf('>', index);
                System.out.println(index);
                int end = index - 1;
                String str = post.substring(start, end);
                System.out.println(str);
                positions.add(positions.size());
            }
        }
        System.out.println(positions.toString());
    }

}
