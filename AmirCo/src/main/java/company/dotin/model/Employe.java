package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "t_employe")
@Entity(name = "t_employe")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(20)")
    private String c_name;
    @Column(columnDefinition = "varchar2(20)")
    private String c_family;
    @Column()
    private boolean c_actication;
    @Column(columnDefinition = "date")
    private Date c_deleteDate;
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

    public Employe(int id, String c_name, String c_family, boolean c_actication, Date c_deleteDate, Employe manager, CategoryElement c_role, int c_version) {
        this.id = id;
        this.c_name = c_name;
        this.c_family = c_family;
        this.c_actication = c_actication;
        this.c_deleteDate = c_deleteDate;
        this.manager = manager;
        this.c_role = c_role;
        this.c_version = c_version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isC_actication() {
        return c_actication;
    }

    public void setC_actication(boolean c_actication) {
        this.c_actication = c_actication;
    }

    public Date getC_deleteDate() {
        return c_deleteDate;
    }

    public void setC_deleteDate(Date c_deleteDate) {
        this.c_deleteDate = c_deleteDate;
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

    public int getC_version() {
        return c_version;
    }

    public void setC_version(int c_version) {
        this.c_version = c_version;
    }
}

