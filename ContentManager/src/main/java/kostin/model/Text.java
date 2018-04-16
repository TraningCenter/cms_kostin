package kostin.model;

import javax.persistence.*;

@Entity
@Table(name="texts")
public class Text {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String content;

    public Text() {
    }

    public Text(Integer id,String content) {
        this.id=id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
