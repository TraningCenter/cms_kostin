package kostin.model;

import java.util.Date;
import java.util.List;

public class Post {

    private Integer id ;

   // private Integer author_id;

    private Date date;

    private String title;

    private Integer textId;

    private List<Image> images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  //  public Integer getAuthor_id() {
  //      return author_id;
  //  }

 //   public void setAuthor_id(Integer author_id) {
    //    this.author_id = author_id;
  //  }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }
}
