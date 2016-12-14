package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.attachmentRepository")
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
}
