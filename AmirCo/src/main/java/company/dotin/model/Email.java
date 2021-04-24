package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "t_email")
@Entity(name = "t_email")
public class Email extends Common implements Serializable{
    @Column(columnDefinition = "varchar2(50)")
    private String c_subject;
    @Column(columnDefinition = "varchar2(1000)")
    private String c_content;
    @ManyToOne
    private Employe c_sender;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "t_juncEmail_Employe", joinColumns = {
            @JoinColumn(name = "Email_ID", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "empoye_Id", referencedColumnName = "id"))
    private List<Employe> c_recivers;

    public Email() {
    }

    public Email(String c_subject, Employe c_sender, List<Employe> c_recivers,String c_content) {
        this.c_content=c_content;
        this.c_subject = c_subject;
        this.c_sender = c_sender;
        this.c_recivers = c_recivers;
    }

    public String getC_subject() {
        return c_subject;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
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