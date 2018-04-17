package kostin.model;

import java.util.List;

public class Image {


    private Integer imageId;

    private Integer cmId;

    private Integer position;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", cmId=" + cmId +
                ", position=" + position +
                '}';
    }
}
