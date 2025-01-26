package edu.nibm.crm.repository;

import edu.nibm.crm.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
