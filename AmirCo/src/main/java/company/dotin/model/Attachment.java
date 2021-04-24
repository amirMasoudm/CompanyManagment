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
    @Column()

    private String docName;
    private String docType;
    @Lob
    private byte[] c_attachmentFile;
    @ManyToOne(fetch = FetchType.EAGER)
    private Email c_email;

    public Attachment() {
    }

    public Attachment(String docName, String docType, byte[] c_attachmentFile, Email c_email) {
        this.docName = docName;
        this.docType = docType;
        this.c_attachmentFile = c_attachmentFile;
        this.c_email = c_email;
    }

    public Attachment(int id, byte[] c_attachmentFile, Email c_email) {
        this.id = id;
        this.c_attachmentFile = c_attachmentFile;
        this.c_email = c_email;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getC_attachmentFile() {
        return c_attachmentFile;
    }

    public void setC_attachmentFile(byte[] c_attachmentFile) {
        this.c_attachmentFile = c_attachmentFile;
    }

    public Email getC_email() {
        return c_email;
    }

    public void setC_email(Email c_email) {
        this.c_email = c_email;
    }
}
