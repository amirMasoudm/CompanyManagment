package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "t_employe")
@Entity(name = "t_employe")
public class Employe extends Common implements Serializable {

    @Column(columnDefinition = "varchar2(255)")
    private String c_name;
    @Column(columnDefinition = "varchar2(255)")
    private String c_family;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_manager_Id")
    private Employe manager;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_roleId")
    private CategoryElement c_role;
    @ManyToMany(mappedBy = "c_recivers")
    private List<Email> emailList;

    public Employe() {

    }

    public Employe(String c_name, String c_family, Employe c_manager, CategoryElement c_role) {
        this.manager = c_manager;
        this.c_role = c_role;
        this.c_name = c_name;
        this.c_family = c_family;
    }

    public Employe(int id, String c_name, String c_family, Employe c_manager, CategoryElement c_role) {
        this.setId(id);
        this.manager = c_manager;
        this.c_role = c_role;
        this.c_name = c_name;
        this.c_family = c_family;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_family() {
        return c_family;
    }

    public void setC_family(String c_family) {
        this.c_family = c_family;
    }

    public Employe getManager() {
        return manager;
    }

    public void setManager(Employe manager) {
        this.manager = manager;
    }

    public CategoryElement getC_role() {
        return c_role;
    }

    public void setC_role(CategoryElement c_role) {
        this.c_role = c_role;
    }
}

