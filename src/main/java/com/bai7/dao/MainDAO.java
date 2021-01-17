package com.bai7.dao;

import com.bai7.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class MainDAO {
    @Autowired
    SessionFactory sessionFactory;
    public Employee  getEmpById(int id) {
        return  (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }
    public List<Employee> getListEmpByHireDate(String date) throws ParseException {
        Date dateSql= Date.valueOf(date);
        String hql= "FROM Employee AS e WHERE e.hireDate > :id";
        Query query= sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id",dateSql);
        List<Employee> list =query.list(); // ko can exercute j
        return list;
    }
    public List<Employee> getListEmpByDept(String dept_no){
        String hql= "SELECT e.empNo, e.birthDate, e.firstName,e.lastName,e.gender,e.hireDate " +
                    "FROM Employee  e , DeptEmp de  WHERE  e.empNo = de.empNo AND de.deptNo= :dept_no   ";
        Query query= sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("dept_no",dept_no);
        query.setMaxResults(100);
        List<Employee> list =query.list(); // ko can exercute j car
        return list;
    }
    public List<Employee> getListEmpBySalary(int salary) throws ParseException {
        String hql=" SELECT e.empNo, e.birthDate, e.firstName,e.lastName,e.gender,e.hireDate " +
                " FROM Employee e , Salaries s " +
                " WHERE e.empNo = s.empNo AND s.toDate= :to_date" +
                " AND s.salary > :salary ";
        Query query= sessionFactory.getCurrentSession().createQuery(hql);
        java.sql.Date date= java.sql.Date.valueOf("9999-01-01");
        query.setParameter("to_date",date);
        query.setParameter("salary",salary);

        List<Employee> list=query.list();
        return list;

    }
    public List<Employee> getListEmpByTitle(String title) throws ParseException {
        String hql=" SELECT e.empNo, e.birthDate, e.firstName,e.lastName,e.gender,e.hireDate " +
                " FROM Employee e , Title t " +
                " WHERE e.empNo = t.empNo AND t.toDate= :to_date" +
                " AND t.title LIKE :title ";
        Query query= sessionFactory.getCurrentSession().createQuery(hql);
        java.sql.Date date= java.sql.Date.valueOf("9999-01-01");
        query.setParameter("to_date",date);
        query.setParameter("title",title );

        List<Employee> list=query.list();
        return list;

    }
    public List<Employee> getListEmp(String salary,String title,String hire_date,String dept_no){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        StringBuilder hql= new StringBuilder();
        hql.append("SELECT DISTINCT e.empNo, e.firstName, e.lastName, e.hireDate , s.salary, de." +
                " FROM Employee e  " +
                " INNER JOIN e.titles   AS t " +
                " INNER JOIN e.salaries AS s " +
                " INNER JOIN e.deptEmps AS de " +
                " WHERE 1=1 ");


        if(!StringUtils.isEmpty(title)){
            hql.append(" AND t.title = :title ");
            map.put("title",title);
        }
        if(!StringUtils.isEmpty(hire_date)){
            hql.append(" AND e.hireDate > :hire_date " );
            map.put("hire_date",java.sql.Date.valueOf(hire_date));
        }
        if(!StringUtils.isEmpty(salary)){
            java.sql.Date to_date= java.sql.Date.valueOf("9999-01-01");
            hql.append(" AND s.salary > :salary " +
                       " AND s.toDate= :to_date ");
            map.put("salary",salary);
            map.put("to_date",to_date);
        }
        if(!StringUtils.isEmpty(dept_no)){
            hql.append(" AND de.deptNo= :dept_no ");
            map.put("dept_no",dept_no);
        }
        Query query= sessionFactory.getCurrentSession().createQuery(hql.toString());
        for(Map.Entry<String,Object> objectEntry:map.entrySet() ){
            query.setParameter(objectEntry.getKey(),objectEntry.getValue());
        }

        List<Employee> list=query.list();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");

        for(Employee e:list){
        //    e.setHireDate(dateFormat.);
        }
        return list;

    }
}
