package com.ixto.lernplan_fsdev.domain;

import com.ixto.lernplan_fsdev.domain.persistence.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for {@link NotesEntity}
 *
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
public interface NotesEntityRepository extends JpaRepository<NotesEntity, UUID> {
  List<NotesEntity> findByBody(String body);
}