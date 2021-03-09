package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "leave")
@Entity(name = "leave")
public class Leave implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "date")
    private Date fromDate;
    @Column(columnDefinition = "date")
    private Date toDate;
    @ManyToOne
    @JoinColumn(name = "statusId")
    private CategoryElement status;
    @ManyToOne
    @JoinColumn(name = "employeId")
    private Employe employe;

    public Leave() {
    }

    public Leave(int id, Date fromDate, Date toDate, CategoryElement status, Employe employe) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public CategoryElement getStatus() {
        return status;
    }

    public void setStatus(CategoryElement status) {
        this.status = status;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
