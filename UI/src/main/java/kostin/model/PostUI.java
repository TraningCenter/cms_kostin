package kostin.model;

import java.util.List;

public class PostUI {

    private String title;

    private List<ImageUI> images;

    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ImageUI> getImages() {
        return images;
    }

    public void setImages(List<ImageUI> images) {
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
