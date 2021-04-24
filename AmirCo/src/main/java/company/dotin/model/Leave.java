package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "t_leave")
@Entity(name = "t_leave")
public class Leave extends Common implements Serializable {

    @Column()
    private LocalDate c_fromDate;
    @Column()
    private LocalDate c_toDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_statusId")
    private CategoryElement c_status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_employeId")
    private Employe c_employe_id;

    public Leave() {
    }

    public Leave(CategoryElement c_status ,LocalDate c_fromDate, LocalDate c_toDate, Employe c_employe) {
        this.c_status=c_status;
        this.c_fromDate = c_fromDate;
        this.c_toDate = c_toDate;
        this.c_employe_id = c_employe;
    }

    public LocalDate getC_fromDate() {
        return c_fromDate;
    }

    public void setC_fromDate(LocalDate c_fromDate) {
        this.c_fromDate = c_fromDate;
    }

    public LocalDate getC_toDate() {
        return c_toDate;
    }

    public void setC_toDate(LocalDate c_toDate) {
        this.c_toDate = c_toDate;
    }

    public CategoryElement getC_status() {
        return c_status;
    }

    public void setC_status(CategoryElement c_status) {
        this.c_status = c_status;
    }

    public Employe getC_employe() {
        return c_employe_id;
    }

    public void setC_employe(Employe c_employe) {
        this.c_employe_id = c_employe;
    }
}