package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeSalaryRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.io.*;
import java.util.Date;  

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;


    @Override
    public Compensation read(String id){
        LOG.debug("Reading compensation of employee with id [{}]", id);
        Compensation compensation = employeeSalaryRepository.getCompensationByEmployee_EmployeeId(id);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }

    @Override
    public Compensation create(Compensation compensation){
        LOG.debug("Creating compensation [{}]", compensation);
        compensation.getEmployee().setEmployeeId(UUID.randomUUID().toString());
        LOG.debug("Unique ID created is: [{}]", compensation.getEmployee().getEmployeeId());
        employeeSalaryRepository.insert(compensation);

        return compensation;
    }
}
