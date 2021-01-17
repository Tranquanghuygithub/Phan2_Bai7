package com.bai7.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@JsonAutoDetect
public class Employee implements Serializable {
    @Id
    @Column(name = "emp_no")
    private int empNo;


//    @JsonFormat(pattern="yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;


   @Column(name = "hire_date")
   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date hireDate;

   @OneToMany(fetch =FetchType.LAZY,mappedBy = "employee")
   private List<Title> titles;

   @OneToMany(fetch =FetchType.LAZY,mappedBy = "employee")
   private List<DeptEmp> deptEmps;

   @OneToMany(fetch =FetchType.LAZY,mappedBy = "employee")
    private List<Salaries> salaries;
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public List<DeptEmp> getDeptEmps() {
        return deptEmps;
    }

    public void setDeptEmps(List<DeptEmp> deptEmps) {
        this.deptEmps = deptEmps;
    }

    public List<Salaries> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salaries> salaries) {
        this.salaries = salaries;
    }

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
