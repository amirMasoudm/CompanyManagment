package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_leave")
@Entity(name = "t_leave")
public class Leave implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    @Column(columnDefinition = "date")
    private Date c_fromDate;
    @Column(columnDefinition = "date")
    private Date c_toDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_statusId")
    private CategoryElement c_status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_employeId")
    private Employe c_employe;

    public Leave() {
    }

    public Leave(int c_id, Date c_fromDate, Date c_toDate, CategoryElement c_status, Employe c_employe) {
        this.c_id = c_id;
        this.c_fromDate = c_fromDate;
        this.c_toDate = c_toDate;
        this.c_status = c_status;
        this.c_employe = c_employe;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public Date getC_fromDate() {
        return c_fromDate;
    }

    public void setC_fromDate(Date c_fromDate) {
        this.c_fromDate = c_fromDate;
    }

    public Date getC_toDate() {
        return c_toDate;
    }

    public void setC_toDate(Date c_toDate) {
        this.c_toDate = c_toDate;
    }

    public CategoryElement getC_status() {
        return c_status;
    }

    public void setC_status(CategoryElement c_status) {
        this.c_status = c_status;
    }

    public Employe getC_employe() {
        return c_employe;
    }

    public void setC_employe(Employe c_employe) {
        this.c_employe = c_employe;
    }
}
