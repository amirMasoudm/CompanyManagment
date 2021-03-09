package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "employe")
@Entity(name = "employe")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(20)")
    private String name;
    @Column(columnDefinition = "varchar2(20)")
    private String family;
    @ManyToOne
    @JoinColumn(name = "manager-Id")
    private Employe manager;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private CategoryElement role;

    public Employe() {
    }

    public Employe(int id, String name, String family, Employe manager, CategoryElement role) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.manager = manager;
        this.role = role;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Employe getManager() {
        return manager;
    }

    public void setManager(Employe manager) {
        this.manager = manager;
    }

    public CategoryElement getRole() {
        return role;
    }

    public void setRole(CategoryElement role) {
        this.role = role;
    }
}
