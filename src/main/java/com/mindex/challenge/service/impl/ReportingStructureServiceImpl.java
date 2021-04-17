package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.UUID;
import java.util.LinkedList;
import java.io.*;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ReportingStructure read(String id){
        LOG.debug("Reading employee with id [{}]", id);
        Queue<Employee> reportResult = new LinkedList<>();
        Employee employee = employeeRepository.findByEmployeeId(id);
        ReportingStructure employeeReport = new ReportingStructure();
        employeeReport.setEmployee(employee);
        int count = 0;
        if (employeeReport == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        if(employeeReport.getEmployee().getDirectReports().size() == 0){
            employeeReport.setNumberOfReports(0);
        }
        else{
            int reportSize = employeeReport.getEmployee().getDirectReports().size(); //2
            //List<Integer> childReport = new ArrayList<>();
            for(int i=0; i<reportSize; i++){
                reportResult.add(employeeReport.getEmployee().getDirectReports().get(i)); 
            }

            while(!reportResult.isEmpty()){
                Employee childEmployee = reportResult.remove();
                count++;
                if(childEmployee.getDirectReports() != null){
                    for(int k=0; k<childEmployee.getDirectReports().size(); k++){
                        reportResult.add(childEmployee.getDirectReports().get(k));
                    }
                }
            }
            employeeReport.setNumberOfReports(count);
        } 
        return employeeReport;
    }

}
