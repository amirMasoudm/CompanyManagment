package company.dotin.controller;

import company.dotin.model.Attachment;
import company.dotin.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AttachmentController {
    @Autowired
    private AttachmentService service;

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
        Attachment attachment = service.findById(fileId);
        if (attachment.getC_attachmentFile() == null) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getDocType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + attachment.getDocName() + "\"")
                    .body(new ByteArrayResource(attachment.getC_attachmentFile()));

        }
    }
}