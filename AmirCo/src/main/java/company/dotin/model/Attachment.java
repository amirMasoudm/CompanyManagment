package company.dotin.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Blob;

@Table(name = "t_attachment")
@Entity(name = "t_attachment")
public class Attachment implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "blob")
    private Blob c_attachmentFile;
    @ManyToOne(fetch = FetchType.LAZY)
    private Email c_email;

    public Attachment() {
    }

    public Attachment(int id, Blob c_attachmentFile, Email c_email) {
        this.id = id;
        this.c_attachmentFile = c_attachmentFile;
        this.c_email = c_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getC_attachmentFile() {
        return c_attachmentFile;
    }

    public void setC_attachmentFile(Blob c_attachmentFile) {
        this.c_attachmentFile = c_attachmentFile;
    }

    public Email getC_email() {
        return c_email;
    }

    public void setC_email(Email c_email) {
        this.c_email = c_email;
    }
}
