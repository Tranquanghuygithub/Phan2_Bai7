package com.bai7.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "dept_name")
    private String deptName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="department")
    List<DeptEmp> deptEmpList;
    public String getDeptNo() {
        return this.deptNo;
    }


    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
