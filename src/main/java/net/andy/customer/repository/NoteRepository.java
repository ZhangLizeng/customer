package net.andy.customer.repository;

import net.andy.customer.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByCustomerId(Long customerId);
}
