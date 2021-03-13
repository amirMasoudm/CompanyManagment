package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "categoryElement")
@Entity(name = "categoryElement")
public class CategoryElement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(20)")
    private String persianName;
    @Column(columnDefinition = "number")
    private int code;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    public CategoryElement() {
    }

    public CategoryElement(int id, String persianName, int code, Category category) {
        this.id = id;
        this.persianName = persianName;
        this.code = code;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
