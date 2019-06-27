package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher, String> {
}
