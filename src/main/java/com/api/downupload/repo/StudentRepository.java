package com.api.downupload.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.downupload.entity.Parents;
import com.api.downupload.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
