package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_category")
@Entity(name = "t_category")
public class Category implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(10)")
    private String c_name;

    public Category() {
    }

    public Category(int id, String c_name) {
        this.id = id;
        this.c_name = c_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
