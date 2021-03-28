package company.dotin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "t_categoryElement")
@Entity(name = "t_categoryElement")
public class CategoryElement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    @Column(columnDefinition = "varchar2(20)")
    private String c_persianName;
    @Column(columnDefinition = "number")
    private int c_code;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_category_Id")
    private Category c_category;

    public CategoryElement() {
    }

    public CategoryElement(int id, String c_persianName, int c_code, Category c_category) {
        this.id = id;
        this.c_persianName = c_persianName;
        this.c_code = c_code;
        this.c_category = c_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_persianName() {
        return c_persianName;
    }

    public void setC_persianName(String c_persianName) {
        this.c_persianName = c_persianName;
    }

    public int getC_code() {
        return c_code;
    }

    public void setC_code(int c_code) {
        this.c_code = c_code;
    }

    public Category getC_category() {
        return c_category;
    }

    public void setC_category(Category c_category) {
        this.c_category = c_category;
    }
}
