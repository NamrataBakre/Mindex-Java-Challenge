package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface EmployeeSalaryRepository extends MongoRepository<Compensation, String> {
    Compensation getCompensationByEmployee_EmployeeId(String employeeId);
}
