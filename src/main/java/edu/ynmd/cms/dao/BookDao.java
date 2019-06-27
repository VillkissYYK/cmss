package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,String> {
}
