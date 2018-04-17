package kostin.model;

public class ImagePm {

    private Integer cmId;

    private Integer position;

    public ImagePm() {
    }

    public ImagePm(Integer cmId, Integer position) {
        this.cmId = cmId;
        this.position = position;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ImagePm{" +
                "cmId=" + cmId +
                ", position=" + position +
                '}';
    }
}
