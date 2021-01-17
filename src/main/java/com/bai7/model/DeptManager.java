package com.bai7.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dept_manager")
public class DeptManager implements Serializable {
    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    public String getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
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
