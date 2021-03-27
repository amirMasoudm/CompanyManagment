package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_category")
@Entity(name = "t_category")
public class Category implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    @Column(columnDefinition = "varchar2(10)")
    private String c_name;

    public Category() {
    }

    public Category(int c_id, String c_name) {
        this.c_id = c_id;
        this.c_name = c_name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
