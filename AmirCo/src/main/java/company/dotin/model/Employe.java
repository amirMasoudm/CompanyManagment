package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "t_employe")
@Entity(name = "t_employe")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    @Column(columnDefinition = "varchar2(20)")
    private String c_name;
    @Column(columnDefinition = "varchar2(20)")
    private String c_family;
    @Column(columnDefinition = "varchar2(20)")
    private int c_actication;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_manager_Id")
    private Employe manager;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_roleId")
    private CategoryElement c_role;
    @Version
    private int c_version;

    public Employe() {
    }

    public Employe(int c_id, String c_name, String c_family, int c_actication, Employe manager, CategoryElement c_role, int c_version) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_family = c_family;
        this.c_actication = c_actication;
        this.manager = manager;
        this.c_role = c_role;
        this.c_version = c_version;
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

    public String getC_family() {
        return c_family;
    }

    public void setC_family(String c_family) {
        this.c_family = c_family;
    }

    public int getC_actication() {
        return c_actication;
    }

    public void setC_actication(int c_actication) {
        this.c_actication = c_actication;
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

    public int getC_version() {
        return c_version;
    }

    public void setC_version(int c_version) {
        this.c_version = c_version;
    }
}

