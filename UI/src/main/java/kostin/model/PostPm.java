package kostin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostPm {

    private Integer id ;

    // private Integer author_id;

    private Date date;

    private String title;

    private Integer textId;

    private List<ImagePm> images= new ArrayList<>();

    public PostPm() {
    }

    public PostPm(Integer id, Date date, String title, Integer textId, List<ImagePm> images) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.textId = textId;
        this.images = images;
    }

    public PostPm(Integer id, Date date, String title, Integer textId) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.textId = textId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public List<ImagePm> getImages() {
        return images;
    }

    public void setImages(List<ImagePm> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "PostPm{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", textId=" + textId +
                ", images=" + images +
                '}';
    }
}
