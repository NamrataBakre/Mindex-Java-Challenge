package com.mindex.challenge.data;
import com.mindex.challenge.data.Employee;
import java.util.Date;

public class Compensation {
    private Employee employee;
    private double salary;
    private Date effectiveDate;

    public Compensation() {
    }

    public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public Date getEffectiveDate(){
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectivDate){
        this.effectiveDate = effectivDate;
    }
}
