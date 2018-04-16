package kostin.dto;

import kostin.model.Image;

import java.util.Date;
import java.util.List;

public class PostDto {

    private Integer id ;

    // private Integer author_id;

    private Date date;

    private String title;

    private Integer textId;

    private List<ImageDto> images;



    public PostDto(Integer id, Date date, String title, Integer textId, List<ImageDto> images) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.textId = textId;
        this.images = images;
    }

    public PostDto() {
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

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }
}
