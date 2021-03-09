package company.dotin.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Blob;

@Table(name = "attachment")
@Entity(name = "attachment")
public class Attachment implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "blob")
    private Blob attachmentFile;
    @ManyToOne
    private Email email;

    public Attachment() {
    }

    public Attachment(int id, Blob attachmentFile, Email email) {
        this.id = id;
        this.attachmentFile = attachmentFile;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(Blob attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
