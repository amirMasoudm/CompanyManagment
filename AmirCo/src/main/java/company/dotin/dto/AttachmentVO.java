package company.dotin.dto;

import company.dotin.model.Attachment;
import company.dotin.model.Email;

import java.util.List;

public class AttachmentVO {
private Email email;
private List<Attachment> attachment;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }
}
