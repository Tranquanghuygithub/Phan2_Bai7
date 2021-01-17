package com.bai7.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dept_emp")
public class DeptEmp implements Serializable {
    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
    @ManyToOne
    @JoinColumn(name = "emp_no",referencedColumnName = "emp_no",nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "dept_no",referencedColumnName = "dept_no",nullable = false)
    private  Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
