package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,String> {
}
