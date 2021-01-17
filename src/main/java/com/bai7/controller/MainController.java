package com.bai7.controller;

import com.bai7.model.Employee;
import com.bai7.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping(value = "/employees/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmpById(@PathVariable(name = "id") int id){
        return mainService.getEmpById(id);
    }
//
//    @GetMapping(value = "/employees/date",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Employee> getEmpByHireDate(@RequestParam(name = "date") String date) throws ParseException {
//
//        return mainService.getListEmpByHireDate(date);
//    }
//    @GetMapping(value = "/employees/deptNo",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Employee> getListEmpByDept(@PathVariable(name = "deptNo") String deptNo)  {
//        return mainService.getListEmpByDept(deptNo);
//    }
//    @GetMapping(value = "/employees/salary",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Employee> getListEmpBySalary(@RequestParam(name = "salary") int salary) throws ParseException {
//        return mainService.getListEmpBySalary(salary);
//    }
    @GetMapping(value = "/employees/title/{title}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getListEmpByTitle(@PathVariable(name = "title") String title) throws ParseException {
        return mainService.getListEmpByTitle(title);
    }
    @GetMapping(value="/employees/find",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getListEmp
    (
            @RequestParam(name = "hire_date",required = false) String date,
            @RequestParam(name = "salary",required = false) String salary,
            @RequestParam(name = "dept_no",required = false) String dept_No,
            @RequestParam(name = "title",required = false) String title

    ) throws ParseException {
        System.out.println("hello");
        return mainService.getListEmp(salary,title,date,dept_No);

    }
}
