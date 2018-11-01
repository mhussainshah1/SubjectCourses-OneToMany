package com.example.lesson10;

import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
  Subject findByTitle(String subject_name);
}
