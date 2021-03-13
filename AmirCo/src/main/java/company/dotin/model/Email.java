package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "email")
@Entity(name = "email")
public class Email implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(50)")
    private String subject;
    @ManyToOne
    private Employe sender;

    @ManyToMany
    @JoinTable(name = "juncEmail_Employe", joinColumns = {
            @JoinColumn(name = "Email_ID", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "empoye_Id", referencedColumnName = "id"))
    private List<Employe> recivers;

    public Email() {
    }

    public Email(int id, String subject, Employe sender, List<Employe> recivers) {
        this.id = id;
        this.subject = subject;
        this.sender = sender;
        this.recivers = recivers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Employe getSender() {
        return sender;
    }

    public void setSender(Employe sender) {
        this.sender = sender;
    }

    public List<Employe> getRecivers() {
        return recivers;
    }

    public void setRecivers(List<Employe> recivers) {
        this.recivers = recivers;
    }
}
