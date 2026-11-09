
package com.university.universitystaffmanagement.repository;

import com.university.universitystaffmanagement.models.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff, String> {
}
