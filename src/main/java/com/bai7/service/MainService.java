package com.bai7.service;

import com.bai7.dao.MainDAO;
import com.bai7.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class MainService {
    @Autowired
    MainDAO mainDAO;
    public Employee getEmpById(int id){
        return mainDAO.getEmpById(id);
    }
    public List<Employee> getListEmpByHireDate(String date) throws ParseException {
        return mainDAO.getListEmpByHireDate(date);
    }
    public  List<Employee> getListEmpByDept(String deptNo){
        return mainDAO.getListEmpByDept(deptNo);

    }
    public List<Employee> getListEmpBySalary(int salary) throws ParseException {
        return mainDAO.getListEmpBySalary(salary);
    }
    public List<Employee> getListEmpByTitle(String title) throws ParseException {
        return mainDAO.getListEmpByTitle(title);
    }
    public List<Employee> getListEmp(String salary,String title,String date,String dept_no) throws ParseException {
        return mainDAO.getListEmp( salary, title,date,dept_no);
    }

}
