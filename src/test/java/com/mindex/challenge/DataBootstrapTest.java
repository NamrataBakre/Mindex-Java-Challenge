package com.mindex.challenge;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());

        ReportingStructure repStruct = new ReportingStructure();
        Employee testEmp = employeeRepository.findByEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");
        repStruct.setEmployee(testEmp);
        assertNotNull(repStruct);
        assertEquals("Ringo", repStruct.getEmployee().getFirstName());
        assertEquals("Starr", repStruct.getEmployee().getLastName());
        assertEquals("Developer V", repStruct.getEmployee().getPosition());
        assertEquals("Engineering", repStruct.getEmployee().getDepartment());
    }
}