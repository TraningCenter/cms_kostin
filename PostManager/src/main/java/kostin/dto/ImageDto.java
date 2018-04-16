package kostin.dto;

public class ImageDto {

    private Integer cmId;

    private Integer position;

    public ImageDto(Integer cmId, Integer position) {
        this.cmId = cmId;
        this.position = position;
    }

    public ImageDto() {
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
}
