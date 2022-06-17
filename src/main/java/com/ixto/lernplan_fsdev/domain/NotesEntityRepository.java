package com.ixto.lernplan_fsdev.domain;

import com.ixto.lernplan_fsdev.domain.persistence.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotesEntityRepository extends JpaRepository<NotesEntity, UUID> {
  List<NotesEntity> findByBody(String body);
}