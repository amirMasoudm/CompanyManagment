package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "t_email")
@Entity(name = "t_email")
public class Email implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    @Column(columnDefinition = "varchar2(50)")
    private String c_subject;
    @ManyToOne
    private Employe c_sender;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_juncEmail_Employe", joinColumns = {
            @JoinColumn(name = "Email_ID", referencedColumnName = "c_id")},
            inverseJoinColumns = @JoinColumn(name = "empoye_Id", referencedColumnName = "c_id"))
    private List<Employe> c_recivers;

    public Email() {
    }

    public Email(int c_id, String c_subject, Employe c_sender, List<Employe> c_recivers) {
        this.c_id = c_id;
        this.c_subject = c_subject;
        this.c_sender = c_sender;
        this.c_recivers = c_recivers;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_subject() {
        return c_subject;
    }

    public void setC_subject(String c_subject) {
        this.c_subject = c_subject;
    }

    public Employe getC_sender() {
        return c_sender;
    }

    public void setC_sender(Employe c_sender) {
        this.c_sender = c_sender;
    }

    public List<Employe> getC_recivers() {
        return c_recivers;
    }

    public void setC_recivers(List<Employe> c_recivers) {
        this.c_recivers = c_recivers;
    }
}

