package com.rest.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Student;
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

}
