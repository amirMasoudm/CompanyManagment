package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "category")
@Entity(name = "category")
public class Category implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(10)")
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
