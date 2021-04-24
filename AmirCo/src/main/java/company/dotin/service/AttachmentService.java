package company.dotin.service;

import company.dotin.model.Attachment;
import company.dotin.model.Email;
import company.dotin.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service

public class AttachmentService {
    @Autowired
    private AttachmentRepository repository;

    public void saveAttachment(Attachment attachment) {
        repository.save(attachment);

    }
    public Attachment attachment(int attachmentId){
        return repository.findById(attachmentId);
    }
    public List<Attachment> EmailAttachments(Email email){
        return repository.findListByEmail(email);
    }

    public List<String> attachmentNames(List<Attachment> attachments){
        List<String> attachtNames=new ArrayList<>();
        for (Attachment name:attachments){
            attachtNames.add(name.getDocName());
        }
        return attachtNames;
    }
    public Attachment findById(int id) {
        return repository.findById(id);

    }
}
