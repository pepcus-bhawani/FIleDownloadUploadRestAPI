package com.api.downupload.repo;

import org.springframework.data.repository.CrudRepository;

import com.api.downupload.entity.StudentEntity;

public interface StudentRepo extends CrudRepository<StudentEntity, Long> {

}
